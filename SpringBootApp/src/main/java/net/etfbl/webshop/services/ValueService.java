package net.etfbl.webshop.services;

import net.etfbl.webshop.models.entities.Value;

public interface ValueService {
    Value findAllValuesByProductIdAndAttributeId(Integer idProduct, Integer idAttribute);

    Value insert(Value value);
}
