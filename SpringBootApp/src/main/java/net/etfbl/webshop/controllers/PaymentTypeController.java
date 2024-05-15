package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.PaymentTypeDTO;
import net.etfbl.webshop.models.entities.PaymentType;
import net.etfbl.webshop.services.PaymentTypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.etfbl.webshop.base.CrudController;

@RestController
@RequestMapping("/api/payment-types")
@CrossOrigin(origins = "http://localhost:4200/")
public class PaymentTypeController extends CrudController<Integer, PaymentType, PaymentTypeDTO> {

    public PaymentTypeController(PaymentTypeService service) {
        super(PaymentTypeDTO.class, service);
    }
}