package net.etfbl.webshop.services;

import net.etfbl.webshop.base.CrudService;
import net.etfbl.webshop.models.dto.PurchaseDTO;

import java.util.List;

public interface PurchaseService extends CrudService<Integer> {
    List<PurchaseDTO> findAllPurchasesByUserId(Integer id);
}
