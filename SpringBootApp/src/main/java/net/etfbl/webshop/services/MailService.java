package net.etfbl.webshop.services;

import net.etfbl.webshop.models.entities.Mail;

public interface MailService {

    String sendMail(Mail mail);
}
