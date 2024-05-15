export class Category {
    id: number;
    name: string;
    parentCategory: Category | null;

    constructor(id: number, name: string, parentCategory: Category | null) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
    }
}