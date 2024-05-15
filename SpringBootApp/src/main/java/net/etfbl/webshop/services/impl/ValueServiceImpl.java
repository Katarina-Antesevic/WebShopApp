package net.etfbl.webshop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.models.entities.Value;
import net.etfbl.webshop.repositories.ValueRepository;
import net.etfbl.webshop.services.ValueService;

@Service
@Transactional
public class ValueServiceImpl implements ValueService {

    private final ValueRepository repository;

    public ValueServiceImpl(ValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Value findAllValuesByProductIdAndAttributeId(Integer idProduct, Integer idAttribute) {
        return repository.findByIdProductAndIdAttribute(idProduct, idAttribute);
    }

    @Override
    public Value insert(Value value) {
        return repository.saveAndFlush(value);
    }
}
