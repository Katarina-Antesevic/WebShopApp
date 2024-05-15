package net.etfbl.webshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeId implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "id_category", nullable = false)
    @Id
    private Integer idCategory;

}
