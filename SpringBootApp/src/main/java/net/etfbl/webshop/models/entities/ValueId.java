package net.etfbl.webshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class ValueId implements Serializable {
    @Column(name = "id_product", nullable = false)
    @Id
    private Integer idProduct;

    @Column(name = "id_attribute", nullable = false)
    @Id
    private Integer idAttribute;

    @Column(name = "id_category", nullable = false)
    @Id
    private Integer idCategory;

}
