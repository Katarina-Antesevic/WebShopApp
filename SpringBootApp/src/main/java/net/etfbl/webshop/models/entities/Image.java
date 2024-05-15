package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

@Data
@Entity
@Table(name = "image")
public class Image implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product product;

}
