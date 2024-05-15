package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.entities.Attribute;
import net.etfbl.webshop.services.AttributeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
@CrossOrigin(origins = "http://localhost:4200/")
public class AttributeController {

    AttributeService service;

    public AttributeController(AttributeService service) {
        this.service = service;
    }

    @GetMapping("/idCategory/{idCategory}")
    public List<Attribute> getAttributesOfCategory(@PathVariable Integer idCategory) {
        return service.findAllAttributesByCategoryId(idCategory);
    }

}
