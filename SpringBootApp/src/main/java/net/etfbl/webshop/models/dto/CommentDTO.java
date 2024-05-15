package net.etfbl.webshop.models.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private Integer id;
    private String content;
    private UserDTO user;
    private OfferDTO offer;

}
