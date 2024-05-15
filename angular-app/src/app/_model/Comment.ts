import { Offer } from "./Offer";
import { User } from "./User";

export class Comment {
    id: number | null;
    content: string;
    user: User;
    offer: Offer;

    constructor(id: number | null, content: string, user: User, offer: Offer) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.offer = offer;
    }
}