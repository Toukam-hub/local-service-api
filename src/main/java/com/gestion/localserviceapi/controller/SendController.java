package com.gestion.localserviceapi.controller;

import com.gestion.localserviceapi.resource.ResourceEmail;
import com.gestion.localserviceapi.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST})
public class SendController {

    private final EmailService emailService;

    public SendController(EmailService emailService) {this.emailService = emailService;}

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody ResourceEmail resourceEmail) {
        String subject = "Sécurité Automobile";
        String text = String.format(
                """                  
                        Contact: %s,
                        Ville: %s,
                        Jour d'installation : %s,
                        Nature de l'Engin: %s,
                        
                        Veuillez contacter Monsieur pour plus de détails.
                        """,
                resourceEmail.contact(),
                resourceEmail.ville(),
                resourceEmail.date(),
                resourceEmail.type()
        );

        this.emailService.envoyerEmail(subject, text);
        return ResponseEntity.ok("{\"message\":\"email bien envoié\"}");
    }
}
