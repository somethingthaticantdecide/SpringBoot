package edu.school21.cinema.controller;

import edu.school21.cinema.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/password_reset")
public class PasswordResetController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public PasswordResetController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @GetMapping()
    public String doGet() {
        return "/password_reset";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doPost(HttpServletRequest request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("");
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("johntom@gmail.com");
        mailMessage.setText("To confirm your account, please click here : ");
        emailSenderService.sendEmail(mailMessage);
        return "redirect:/signIn";
    }
}