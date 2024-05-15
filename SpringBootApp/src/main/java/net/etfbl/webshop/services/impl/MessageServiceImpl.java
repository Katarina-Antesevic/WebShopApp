package net.etfbl.webshop.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.webshop.base.CrudJpaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import net.etfbl.webshop.models.entities.Message;
import net.etfbl.webshop.repositories.MessageRepository;
import net.etfbl.webshop.services.MessageService;

@Service
@Transactional
public class MessageServiceImpl extends CrudJpaService<Message, Integer> implements MessageService {
    public MessageServiceImpl(MessageRepository repository, ModelMapper modelMapper) {
        super(repository, Message.class, modelMapper);
    }
}
