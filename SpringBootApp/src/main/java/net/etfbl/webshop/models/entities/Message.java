package net.etfbl.webshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

@Data
@Entity
@Table(name = "message")
public class Message implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @Basic
    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    @Basic
    @Column(name = "date_time", nullable = false)
    private String dateTime;

    @Basic
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

}