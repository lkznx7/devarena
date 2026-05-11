package com.devarena.modules.email.service;


import com.devarena.modules.email.dto.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class EmailService {

    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }
    public void sendEmail(Email email) {

        var message = new SimpleMailMessage();
        message.setFrom("noreply@email.com"); // REMETENTE
        message.setTo(email.to()); // DESTINATARIO
        message.setSubject(email.subject()); // ASSUNTO
        message.setText(email.body()); // CORPO EMAIL , POR TOKEN PARA A VERIFICAÇÃO

        mailSender.send(message); // DISPARA EMAIL

    }

}
