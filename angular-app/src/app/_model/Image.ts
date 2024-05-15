export class Image {
    id: number;
    url: string;
    idProduct: number;

    constructor(id: number, url: string, idProduct: number) {
        this.id = id;
        this.url = url;
        this.idProduct = idProduct;
    }
}