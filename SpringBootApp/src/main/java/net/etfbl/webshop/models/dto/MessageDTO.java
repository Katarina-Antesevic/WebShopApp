package net.etfbl.webshop.models.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private Integer id;
    private String content;
    private Integer idUser;
    private Boolean isRead;
    private String dateTime;

}
