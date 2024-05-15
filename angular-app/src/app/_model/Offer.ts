import { Product } from "./Product";

export class Offer {
    id: number | null;
    idUser: number;
    product: Product;
    isActive: boolean;

    constructor(id: number | null, idUser: number, product: Product, isActive: boolean) {
        this.id = id;
        this.idUser = idUser;
        this.product = product;
        this.isActive = isActive;
    }
}