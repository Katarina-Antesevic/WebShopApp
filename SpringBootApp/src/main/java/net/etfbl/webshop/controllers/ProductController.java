package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.ProductDTO;
import net.etfbl.webshop.models.entities.AttributeValue;
import net.etfbl.webshop.models.entities.Product;
import net.etfbl.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;
import net.etfbl.webshop.base.CrudController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController extends CrudController<Integer, Product, ProductDTO> {

    ProductService productService;

    public ProductController(ProductService service) {
        super(ProductDTO.class, service);
        productService = service;
    }

    @GetMapping("/attributes-values/{id}")
    public List<AttributeValue> getAttributesAndValues(@PathVariable Integer id) {
        return productService.getAttributesAndValues(id);
    }
}
