package net.etfbl.webshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.etfbl.webshop.base.CrudJpaService;
import net.etfbl.webshop.models.entities.Image;
import net.etfbl.webshop.repositories.ImageRepository;
import net.etfbl.webshop.services.ImageService;

@Service
@Transactional
public class ImageServiceImpl extends CrudJpaService<Image, Integer> implements ImageService {

    private final ImageRepository repository;

    public ImageServiceImpl(ImageRepository repository, ModelMapper mapper) {
        super(repository, Image.class, mapper);
        this.repository = repository;
    }

}
