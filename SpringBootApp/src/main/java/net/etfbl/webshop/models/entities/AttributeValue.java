package net.etfbl.webshop.models.entities;

import lombok.Data;

@Data
public class AttributeValue {
    private Integer idProduct;
    private Integer idAttribute;
    private String attributeName;
    private String valueValue;

    public AttributeValue() {

    }

    public AttributeValue(Integer idProduct, Integer idAttribute, String attributeName, String valueValue) {
        this.idAttribute = idAttribute;
        this.idProduct = idProduct;
        this.attributeName = attributeName;
        this.valueValue = valueValue;
    }
}
