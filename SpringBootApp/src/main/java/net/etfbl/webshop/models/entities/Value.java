package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(ValueId.class)
@Table(name = "value")
public class Value {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_attribute", nullable = false)
    private Integer idAttribute;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "value", nullable = false)
    private String value;

}
