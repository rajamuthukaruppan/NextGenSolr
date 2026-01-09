const observer = new IntersectionObserver(entries=>{
  entries.forEach(e=>{
    if(e.isIntersecting){e.target.classList.add("in-view")}
  })
},{threshold:0.15});

document.querySelectorAll("[data-animate]").forEach(el=>observer.observe(el));

/* Dark mode toggle */
const toggle=document.getElementById("themeToggle");
const root=document.documentElement;
const saved=localStorage.getItem("theme");
if(saved)root.setAttribute("data-theme",saved);

toggle.addEventListener("click",()=>{
  const mode=root.getAttribute("data-theme")==="dark"?"":"dark";
  root.setAttribute("data-theme",mode);
  localStorage.setItem("theme",mode);
});