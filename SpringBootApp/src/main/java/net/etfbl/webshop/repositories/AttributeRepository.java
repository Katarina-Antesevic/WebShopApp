package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Attribute;
import net.etfbl.webshop.models.entities.AttributeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, AttributeId> {
    List<Attribute> findAllAttributesByIdCategory(Integer idCategory);
}
