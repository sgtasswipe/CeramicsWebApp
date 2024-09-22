package com.example.ceramicwebpage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendContactEmail(String name, String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("ottobjornronhof@gmail.com");
        mailMessage.setSubject("New Contact Form Submission");
        mailMessage.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);

        try {
            mailSender.send(mailMessage);
            logger.info("Email sent successfully to {}", mailMessage.getTo()[0]);
            return true;
        } catch (Exception e) {
            logger.error("Failed to send email: {}", e.getMessage());
            return false;
        }
    }
}
