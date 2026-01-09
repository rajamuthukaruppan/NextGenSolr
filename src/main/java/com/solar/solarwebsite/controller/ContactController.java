package com.solar.solarwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.solar.solarwebsite.service.EmailService;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-enquiry")
    public String sendEnquiry(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String message,
            RedirectAttributes redirectAttributes
    ) throws Exception {

        emailService.sendContactMail(name, phone, email, message);

        // ✅ Flash attribute (SAFE & RELIABLE)
        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Thank you! We will contact you shortly."
        );

        // ✅ Anchor keeps scroll near form
        return "redirect:/contact#contact-form";
    }
}