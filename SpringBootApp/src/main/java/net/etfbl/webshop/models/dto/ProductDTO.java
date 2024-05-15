package net.etfbl.webshop.models.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean isNew;
    private String contact;
    private CategoryDTO category;
    private String address;
    private List<ImageDTO> images;

}
