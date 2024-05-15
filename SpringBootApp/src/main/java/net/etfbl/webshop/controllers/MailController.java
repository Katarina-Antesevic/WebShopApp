package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.entities.Mail;
import net.etfbl.webshop.services.impl.MailServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "http://localhost:4200/")
public class MailController {

    private final MailServiceImpl mailService;

    public MailController(MailServiceImpl mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public String insert(@RequestBody Mail mail) {
        return mailService.sendMail(mail);
    }
}
