package net.etfbl.webshop.controllers;

import net.etfbl.webshop.base.CrudController;
import net.etfbl.webshop.models.dto.ImageDTO;
import net.etfbl.webshop.models.entities.Image;
import net.etfbl.webshop.services.ImageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:4200/")
public class ImageController extends CrudController<Integer, Image, ImageDTO> {

    private final ImageService service;

    public ImageController(ImageService service) {
        super(ImageDTO.class, service);
        this.service = service;
    }
}
