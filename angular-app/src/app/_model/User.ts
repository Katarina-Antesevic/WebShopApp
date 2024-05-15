export class User {
    id: number | null;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    city: string;
    mail: string;
    avatar: string | null;
    pin: string;
    isActivated: boolean;

    constructor(id: number | null, firstName: string, lastName: string, username: string, password: string, city: string,
        mail: string, avatar: string | null, pin: string, isActivated: boolean) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.city = city;
        this.mail = mail;
        this.avatar = avatar;
        this.pin = pin;
        this.isActivated = isActivated;
    }
}