package net.etfbl.webshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;

    @Basic
    @Column(name = "is_new", nullable = false)
    private Boolean isNew;

    @Basic
    @Column(name = "contact", nullable = false, length = 45)
    private String contact;

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", referencedColumnName = "id", nullable = false)
    private Category category;

}
