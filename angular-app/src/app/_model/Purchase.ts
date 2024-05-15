import { Offer } from "./Offer";
import { PaymentType } from "./PaymentType";
import { User } from "./User";

export class Purchase {
    id: number | null;
    cardNumber: string | null;
    dateTime: string | null;
    offer: Offer;
    paymentType: PaymentType;
    user: User;

    constructor(id: number | null, cardNumber: string | null, dateTime: string, offer: Offer, paymentType: PaymentType,
        user: User) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.dateTime = dateTime;
        this.offer = offer;
        this.paymentType = paymentType;
        this.user = user;
    }

}