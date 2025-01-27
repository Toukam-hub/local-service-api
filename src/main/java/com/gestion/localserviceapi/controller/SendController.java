package com.gestion.localserviceapi.controller;

import com.gestion.localserviceapi.resource.ResourceEmail;
import com.gestion.localserviceapi.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SendController {

    private final EmailService emailService;

    public SendController(EmailService emailService) {this.emailService = emailService;}

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody ResourceEmail resourceEmail){
        this.emailService.envoyerEmail(resourceEmail.subject(), resourceEmail.text());
        return ResponseEntity.ok("email bien envoye");
    }
}
