package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.base.CrudJpaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.exceptions.ConflictException;
import net.etfbl.webshop.models.entities.PaymentType;
import net.etfbl.webshop.repositories.PaymentTypeRepository;
import net.etfbl.webshop.services.PaymentTypeService;

@Service
@Transactional
public class PaymentTypeServiceImpl extends CrudJpaService<PaymentType, Integer> implements PaymentTypeService {

    private final PaymentTypeRepository repository;

    public PaymentTypeServiceImpl(PaymentTypeRepository repository, ModelMapper modelMapper) {
        super(repository, PaymentType.class, modelMapper);
        this.repository = repository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByName(getModelMapper().map(object, getEntityClass()).getName()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByNameAndIdNot(getModelMapper().map(object, getEntityClass()).getName(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

}
