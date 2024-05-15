package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.CategoryDTO;
import net.etfbl.webshop.models.entities.Category;
import net.etfbl.webshop.services.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.etfbl.webshop.base.CrudController;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController extends CrudController<Integer, Category, CategoryDTO> {

    public CategoryController(CategoryService service) {
        super(CategoryDTO.class, service);
    }


}
