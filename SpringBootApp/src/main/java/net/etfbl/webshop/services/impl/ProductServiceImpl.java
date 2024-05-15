package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.base.CrudJpaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.models.entities.AttributeValue;
import net.etfbl.webshop.models.entities.Product;
import net.etfbl.webshop.repositories.ProductRepository;
import net.etfbl.webshop.services.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends CrudJpaService<Product, Integer> implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper) {
        super(repository, Product.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AttributeValue> getAttributesAndValues(Integer id) {
        return repository.getAttributesAndValues(id);
    }
}
