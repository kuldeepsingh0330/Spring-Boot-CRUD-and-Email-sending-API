package com.webservice.API.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.API.Service.MailService;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("message") String text) {
        

        System.out.println(to+" "+subject);
    	try {
            mailService.sendEmail(to, subject, text);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }

}

