package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@IdClass(AttributeId.class)
@Table(name = "attribute")
public class Attribute {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_category", nullable = false, insertable = false, updatable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

}
