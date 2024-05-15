package net.etfbl.webshop.models.dto;

import lombok.Data;
import net.etfbl.webshop.models.entities.Category;

@Data
public class CategoryDTO {

    private Integer id;
    private String name;
    private Category parentCategory;

}
