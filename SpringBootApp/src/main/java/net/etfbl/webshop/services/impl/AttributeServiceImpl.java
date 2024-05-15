package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.models.entities.Attribute;
import net.etfbl.webshop.repositories.AttributeRepository;
import net.etfbl.webshop.services.AttributeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository repository;
    private final ModelMapper modelMapper;

    public AttributeServiceImpl(AttributeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Attribute> findAllAttributesByCategoryId(Integer idCategory) {
        return repository.findAllAttributesByIdCategory(idCategory);
    }

}
