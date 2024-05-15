package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.base.CrudJpaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.exceptions.ConflictException;
import net.etfbl.webshop.exceptions.NotFoundException;
import net.etfbl.webshop.models.dto.UserDTO;
import net.etfbl.webshop.models.entities.User;
import net.etfbl.webshop.repositories.UserRepository;
import net.etfbl.webshop.services.UserService;

@Service
@Transactional
public class UserServiceImpl extends CrudJpaService<User, Integer> implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userAccountRepository, ModelMapper modelMapper) {
        super(userAccountRepository, User.class, modelMapper);
        this.repository = userAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByUsername(getModelMapper().map(object, getEntityClass()).getUsername()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByUsernameAndIdNot(getModelMapper().map(object, getEntityClass()).getUsername(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

    @Override
    public UserDTO findUserByUsername(String username) throws NotFoundException {
        return modelMapper.map(repository.findByUsername(username).orElseThrow(NotFoundException::new), UserDTO.class);
    }
}
