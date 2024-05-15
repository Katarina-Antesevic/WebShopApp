package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.MessageDTO;
import net.etfbl.webshop.models.entities.Message;
import net.etfbl.webshop.services.MessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.etfbl.webshop.base.CrudController;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:4200/")
public class MessageController extends CrudController<Integer, Message, MessageDTO> {

    public MessageController(MessageService messageService) {
        super(MessageDTO.class, messageService);
    }
}
