package net.etfbl.webshop.models.dto;

import lombok.Data;

@Data
public class OfferDTO {

    private Integer id;
    private Integer idUser;
    private ProductDTO product;
    private Boolean isActive;

}
