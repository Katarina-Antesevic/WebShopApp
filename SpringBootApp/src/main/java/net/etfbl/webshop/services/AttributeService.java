package net.etfbl.webshop.services;

import net.etfbl.webshop.models.entities.Attribute;

import java.util.List;

public interface AttributeService{
    List<Attribute> findAllAttributesByCategoryId(Integer idCategory);
}
