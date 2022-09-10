package com.gsfranzoni.springemailmicroservice.controller;

import com.gsfranzoni.springemailmicroservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "email")
@AllArgsConstructor
public class EmailSenderController {

    public record EmailSenderRequest(String receiver, String subject, String content) {}

    public record EmailSenderResponse(String message) {}

    protected final EmailService emailSenderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailSenderResponse> send(@RequestBody EmailSenderRequest request) {
        try {
            this.emailSenderService.sendEmail(request.receiver(), request.subject(), request.content());
            return ResponseEntity.ok(new EmailSenderResponse("Email sent successfully"));
        } catch (Throwable throwable) {
            return ResponseEntity.badRequest().body(new EmailSenderResponse("Error sending email"));
        }
    }
}
