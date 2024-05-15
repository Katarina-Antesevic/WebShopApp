package net.etfbl.webshop.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import net.etfbl.webshop.base.CrudJpaService;
import net.etfbl.webshop.models.dto.PurchaseDTO;
import net.etfbl.webshop.models.entities.Purchase;
import net.etfbl.webshop.repositories.PurchaseRepository;
import net.etfbl.webshop.services.PurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseServiceImpl extends CrudJpaService<Purchase, Integer> implements PurchaseService {

    private final ModelMapper modelMapper;
    private final PurchaseRepository repository;

    public PurchaseServiceImpl(ModelMapper modelMapper, PurchaseRepository repository) {
        super(repository, Purchase.class, modelMapper);
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<PurchaseDTO> findAllPurchasesByUserId(Integer id) {
        return repository.searchByIdUser(id).stream().map(e -> modelMapper.map(e, PurchaseDTO.class)).collect(Collectors.toList());
    }
}
