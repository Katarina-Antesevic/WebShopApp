package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.OfferDTO;
import net.etfbl.webshop.models.entities.Offer;
import net.etfbl.webshop.services.OfferService;
import org.springframework.web.bind.annotation.*;
import net.etfbl.webshop.base.CrudController;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = "http://localhost:4200/")
public class OfferController extends CrudController<Integer, Offer, OfferDTO> {

    private final OfferService service;

    public OfferController(OfferService service) {
        super(OfferDTO.class, service);
        this.service = service;
    }


    @GetMapping("/existing")
    public List<OfferDTO> findAllExisting() {
        return service.findAll();
    }


    @GetMapping("/idCategory/{id}")
    public List<OfferDTO> findByCategoryId(@PathVariable Integer id) {
        return service.getAllOffersByCategoryId(id);
    }

    @GetMapping("/idUser/{id}")
    public List<OfferDTO> findByUserId(@PathVariable Integer id) {
        return service.getAllOffersByUserId(id);
    }

}
