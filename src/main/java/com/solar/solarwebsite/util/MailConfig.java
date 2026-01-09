package com.solar.solarwebsite.util;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfig {
	
	@Bean
    public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("172.26.45.89");
        mailSender.setPort(25);
        Properties properies = mailSender.getJavaMailProperties();
        properies.put("mail.smtp.host", "smtp.gmail.com");
        properies.put("mail.smtp.port", "25");
        properies.put("mail.smtp.starttls.enable", "false");
        properies.put("mail.smtp.starttls.required", "false");
        properies.put("mail.smtp.ssl.enable", "false");
        
        return mailSender;
    }
	

}
