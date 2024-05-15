package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

@Data
@Entity
@Table(name = "comment")
public class Comment implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_offer", referencedColumnName = "id", nullable = false)
    private Offer offer;

}
