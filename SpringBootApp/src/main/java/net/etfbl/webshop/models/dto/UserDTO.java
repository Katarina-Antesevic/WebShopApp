package net.etfbl.webshop.models.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String avatar;
    private String mail;
    private String pin;
    private Boolean isActivated;

}
