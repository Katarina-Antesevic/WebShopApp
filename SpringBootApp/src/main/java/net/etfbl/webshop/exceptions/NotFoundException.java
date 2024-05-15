package net.etfbl.webshop.exceptions;

import org.springframework.http.HttpStatus;


// Statusni kod 404
public class NotFoundException extends HttpException {
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, null);
    }

    public NotFoundException(Object data) {
        super(HttpStatus.NOT_FOUND, data);
    }
}
