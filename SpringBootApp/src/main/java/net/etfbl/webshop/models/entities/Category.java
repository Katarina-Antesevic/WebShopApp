package net.etfbl.webshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent_category", referencedColumnName = "id", nullable = true)
    private Category parentCategory;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

}
