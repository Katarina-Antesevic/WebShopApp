package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.entities.Value;
import net.etfbl.webshop.services.ValueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/values")
@CrossOrigin(origins = "http://localhost:4200/")
public class ValueController {
    private final ValueService service;

    public ValueController(ValueService service) {
        this.service = service;
    }

    @GetMapping("/idProduct/{idProduct}/idAttribute/{idAttribute}")
    public Value getValueOfAttributeForProduct(@PathVariable Integer idProduct, @PathVariable Integer idAttribute) {
        return service.findAllValuesByProductIdAndAttributeId(idProduct, idAttribute);
    }

    @PostMapping
    public Value insert(@RequestBody Value value) {
        return service.insert(value);
    }
}
