package com.example.ceramicwebpage.controllers;

import com.example.ceramicwebpage.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contact")
    public String submitContactForm(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        boolean emailSent = emailService.sendContactEmail(name, email, message);
        if (emailSent) {
            model.addAttribute("successMessage", "Your message has been sent successfully!");
        } else {
            model.addAttribute("errorMessage", "There was an error sending your message. Please try again later.");
        }
        return "contact";
    }
}