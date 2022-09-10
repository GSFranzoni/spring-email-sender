package com.gsfranzoni.springemailmicroservice.service;

import com.gsfranzoni.springemailmicroservice.model.Email;
import com.gsfranzoni.springemailmicroservice.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value( "${spring.mail.username}" )
    protected String sender;

    protected final JavaMailSenderImpl mailSender;

    protected final EmailRepository repository;

    public void sendEmail(String receiver, String subject, String content) throws MessagingException {
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(this.sender);
        helper.setTo(receiver);
        helper.setSubject(subject);
        helper.setText(content);
        this.mailSender.send(message);
        this.createEmail(receiver, subject, content);
    }

    public void createEmail(String receiver, String subject, String content) {
        Email email = Email.builder()
                .uuid(UUID.randomUUID().toString())
                .sender(this.sender)
                .receiver(receiver)
                .subject(subject)
                .content(content)
                .build();
        this.repository.save(email);
    }
}
