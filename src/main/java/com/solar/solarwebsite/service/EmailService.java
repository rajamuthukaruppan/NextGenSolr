package com.solar.solarwebsite.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solar.solarwebsite.util.CommonUtil;

import jakarta.mail.MessagingException;

@Service
public class EmailService {	

	@Autowired
	CommonUtil commonUtil;

    public void sendContactMail(
            String name,
            String phone,
            String email,
            String message
    ) throws MessagingException {

       // MimeMessage mimeMessage = mailSender.createMimeMessage();
        //MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        //helper.setTo("raja.muthukaruppan1@gmail.com");     // Receiver
        //helper.setSubject("🚀 New Solar Enquiry");

        String htmlContent = """
        <!DOCTYPE html>
        <html>
        <head>
          <meta charset="UTF-8">
        </head>
        <body style="margin:0;padding:0;background:#f9fafb;font-family:Arial,Helvetica,sans-serif;">
          
          <table width="100%%" cellpadding="0" cellspacing="0" style="padding:30px;">
            <tr>
              <td align="center">
                
                <table width="600" cellpadding="0" cellspacing="0"
                  style="background:#ffffff;border-radius:12px;
                         box-shadow:0 10px 30px rgba(0,0,0,0.1);
                         overflow:hidden;">
                  
                  <!-- HEADER -->
                  <tr>
                    <td style="background:linear-gradient(135deg,#0f766e,#2563eb);
                               padding:20px;color:#ffffff;">
                      <h2 style="margin:0;font-size:22px;">
                        New Solar Enquiry
                      </h2>
                    </td>
                  </tr>

                  <!-- BODY -->
                  <tr>
                    <td style="padding:30px;color:#0f172a;">
                      
                      <p style="font-size:15px;margin-bottom:20px;">
                        You have received a new enquiry from your website.
                      </p>

                      <table width="100%%" cellpadding="8" cellspacing="0"
                        style="border-collapse:collapse;font-size:14px;">
                        
                        <tr style="background:#f1f5f9;">
                          <td style="font-weight:bold;">Name</td>
                          <td>%s</td>
                        </tr>

                        <tr>
                          <td style="font-weight:bold;">Phone</td>
                          <td>%s</td>
                        </tr>

                        <tr style="background:#f1f5f9;">
                          <td style="font-weight:bold;">Email</td>
                          <td>%s</td>
                        </tr>

                        <tr>
                          <td style="font-weight:bold;">Message</td>
                          <td>%s</td>
                        </tr>

                      </table>

                      <p style="margin-top:30px;font-size:13px;color:#64748b;">
                        Reply directly to this email or contact the customer by phone.
                      </p>

                    </td>
                  </tr>

                  <!-- FOOTER -->
                  <tr>
                    <td style="background:#f8fafc;
                               padding:15px;
                               text-align:center;
                               font-size:12px;
                               color:#64748b;">
                      © 2026 SolarPower Solutions
                    </td>
                  </tr>

                </table>

              </td>
            </tr>
          </table>

        </body>
        </html>
        """.formatted(
                escape(name),
                escape(phone),
                escape(email),
                escape(message)
        );
        new Thread(() -> {
			try {
        commonUtil.sendEmailWithToMailId("Newn Solar Enquiry", htmlContent, "raja.muthukaruppan@gmail.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
     //  helper.setText(htm	lContent, true);
       // mailSender.send(mimeMessage);
    }

    // Basic HTML escaping for safety
    private String escape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;");
    }
}
