package net.etfbl.webshop.services;

import net.etfbl.webshop.base.CrudService;
import net.etfbl.webshop.models.dto.OfferDTO;

import java.util.List;

public interface OfferService extends CrudService<Integer> {

    List<OfferDTO> getAllOffersByCategoryId(Integer id);

    List<OfferDTO> getAllOffersByUserId(Integer id);

    List<OfferDTO> findAll();
}
