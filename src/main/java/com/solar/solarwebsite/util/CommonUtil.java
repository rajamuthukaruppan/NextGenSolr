package com.solar.solarwebsite.util;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class CommonUtil {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtil.class);
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	MailConfig mailConfig;
	
	
	Date date;
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	public void sendEmailWithToMailId(String subject,String body,String toMailId) {

		try {
	    	System.out.println("subject " +subject);
	    	System.out.println("body " +body);
	    	MimeMessage message = mailConfig.getJavaMailSender().createMimeMessage();
	    	MimeMessageHelper helper = new MimeMessageHelper(message);
	    	helper.setFrom(from);
	       //message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	       String[] toArray = toMailId.split(",");
	       helper.setTo(toArray);
	       //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
	       
	       helper.setSubject(subject);
	       if(body != null) {
	    	   helper.setText(body,true);
	       }
	       mailConfig.getJavaMailSender().send(message);
	    } catch (Exception mex) {
	       mex.printStackTrace();
	    }
	}
	
	
}