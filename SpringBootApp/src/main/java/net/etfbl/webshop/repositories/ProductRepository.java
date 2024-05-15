package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.AttributeValue;
import net.etfbl.webshop.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new net.etfbl.webshop.models.entities.AttributeValue(v.idProduct, a.id, a.name, v.value)" +
            " FROM Attribute a INNER JOIN Value v ON a.id=v.idAttribute WHERE v.idProduct=:id")
    List<AttributeValue> getAttributesAndValues(Integer id);
}
