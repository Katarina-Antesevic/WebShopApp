package net.etfbl.webshop.services.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import net.etfbl.webshop.models.entities.Mail;
import net.etfbl.webshop.services.MailService;


@Service
public class MailServiceImpl implements MailService {
    private static final String SUBJECT = "PIN za aktivaciju naloga";
    private static final String USERNAME = "korisnicka.podrska.webshop@gmail.com";
    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendMail(Mail mail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(USERNAME);
            mailMessage.setSubject(SUBJECT);
            mailMessage.setTo(mail.getReceiver());
            mailMessage.setText(mail.getContent());
            javaMailSender.send(mailMessage);
            return "Mail je uspjesno poslat!";
        } catch (Exception e) {
            return "Slanje maila nije uspjesno!";
        }
    }

}
