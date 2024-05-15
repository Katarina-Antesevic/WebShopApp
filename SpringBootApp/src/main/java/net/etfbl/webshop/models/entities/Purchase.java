package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

@Data
@Entity
@Table(name = "purchase")
public class Purchase implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "date_time", nullable = false)
    private String dateTime;

    @Basic
    @Column(name = "card_number", length = 45)
    private String cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_offer", referencedColumnName = "id", nullable = false)
    private Offer offer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_payment_type", referencedColumnName = "id", nullable = false)
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

}
