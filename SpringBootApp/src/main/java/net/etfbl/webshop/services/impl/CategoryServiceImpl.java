package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.base.CrudJpaService;
import net.etfbl.webshop.models.entities.Category;
import net.etfbl.webshop.repositories.CategoryRepository;
import net.etfbl.webshop.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CategoryServiceImpl extends CrudJpaService<Category, Integer> implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository repository, ModelMapper mapper) {
        super(repository, Category.class, mapper);
        this.repository = repository;
        this.modelMapper = mapper;
    }
}
