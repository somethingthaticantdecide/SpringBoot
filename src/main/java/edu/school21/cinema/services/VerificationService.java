package edu.school21.cinema.services;

import edu.school21.cinema.model.ConfirmationToken;
import edu.school21.cinema.model.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {
    private final EmailSenderService emailSenderService;

    public VerificationService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @Async
    public void sendVerificationEmail(User user, ConfirmationToken confirmationToken) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : http://localhost:8080/confirm/"
                + confirmationToken.getConfirmationToken());
        emailSenderService.sendEmail(mailMessage);
    }
}
