package net.etfbl.webshop.controllers;

import net.etfbl.webshop.base.CrudController;
import net.etfbl.webshop.models.dto.PurchaseDTO;
import net.etfbl.webshop.models.entities.Purchase;
import net.etfbl.webshop.services.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "http://localhost:4200/")
public class PurchaseController extends CrudController<Integer, Purchase, PurchaseDTO> {
    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        super(PurchaseDTO.class, service);
        this.service = service;
    }

    @GetMapping("/idUser/{id}")
    public List<PurchaseDTO> findByUserId(@PathVariable Integer id) {
        return service.findAllPurchasesByUserId(id);
    }

}
