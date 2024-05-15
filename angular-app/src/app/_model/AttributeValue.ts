export class AttributeValue {
    idProduct: number;
    idAttribute: number;
    name: string;
    value: string;

    constructor(idProduct: number, idAttribute: number, name: string, value: string) {
        this.idProduct = idProduct;
        this.idAttribute = idAttribute;
        this.name = name;
        this.value = value;
    }

}