package net.etfbl.webshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import net.etfbl.webshop.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Basic
    @Column(name = "avatar", length = 500)
    private String avatar;

    @Basic
    @Column(name = "mail", nullable = false, length = 45)
    private String mail;

    @Basic
    @Column(name = "pin", nullable = false, length = 45)
    private String pin;

    @Basic
    @Column(name = "is_activated", nullable = false)
    private Boolean isActivated;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Purchase> purchases;

}
