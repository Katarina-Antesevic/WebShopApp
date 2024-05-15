package net.etfbl.webshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.base.CrudJpaService;
import net.etfbl.webshop.models.dto.OfferDTO;
import net.etfbl.webshop.models.entities.Offer;
import net.etfbl.webshop.repositories.OfferRepository;
import net.etfbl.webshop.services.OfferService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OfferServiceImpl extends CrudJpaService<Offer, Integer> implements OfferService {

    private final OfferRepository repository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository repository, ModelMapper modelMapper) {
        super(repository, Offer.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<OfferDTO> getAllOffersByCategoryId(Integer id) {
        return repository.searchByCategoryId(id).stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getAllOffersByUserId(Integer id) {
        return repository.searchByIdUser(id).stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> findAll() {
        return repository.findAllExisting().stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }
}
