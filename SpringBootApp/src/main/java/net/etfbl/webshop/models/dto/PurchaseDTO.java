package net.etfbl.webshop.models.dto;

import lombok.Data;

@Data
public class PurchaseDTO {

    private Integer id;
    private String dateTime;
    private String cardNumber;
    private PaymentTypeDTO paymentType;
    private OfferDTO offer;
    private UserDTO user;

}
