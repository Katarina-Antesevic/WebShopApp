import { Category } from "./Category";
import { Image } from "./Image"

export class Product {
    id: number | null;
    address: string;
    contact: string;
    isNew: boolean;
    description: string;
    name: string;
    price: number;
    category: Category;
    images: Image[];

    constructor(id: number | null, address: string, contact: string, isNew: boolean, description: string, name: string,
        price: number, category: Category, images: Image[]) {
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.isNew = isNew;
        this.description = description;
        this.name = name;
        this.price = price;
        this.category = category;
        this.images = images;
    }



}