package net.etfbl.webshop.services;

import net.etfbl.webshop.base.CrudService;
import net.etfbl.webshop.models.entities.AttributeValue;

import java.util.List;

public interface ProductService extends CrudService<Integer> {
    List<AttributeValue> getAttributesAndValues(Integer id);
}
