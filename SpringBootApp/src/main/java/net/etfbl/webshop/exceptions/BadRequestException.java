package net.etfbl.webshop.exceptions;

import org.springframework.http.HttpStatus;

// Odgovara statusnom kodu 400
public class BadRequestException extends HttpException {
    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST, null);
    }

    public BadRequestException(Object data) {
        super(HttpStatus.BAD_REQUEST, data);
    }
}
