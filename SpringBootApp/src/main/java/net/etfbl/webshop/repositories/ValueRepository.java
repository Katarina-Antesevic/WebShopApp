package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Value;
import net.etfbl.webshop.models.entities.ValueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, ValueId> {
    Value findByIdProductAndIdAttribute(Integer idProduct, Integer idAttribute);
}
