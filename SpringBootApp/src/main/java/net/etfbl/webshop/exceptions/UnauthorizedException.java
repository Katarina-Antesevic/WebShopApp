package net.etfbl.webshop.exceptions;

import org.springframework.http.HttpStatus;

//Statusni kod 401
public class UnauthorizedException extends HttpException {
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED, null);
    }

    public UnauthorizedException(Object data) {
        super(HttpStatus.UNAUTHORIZED, data);
    }
}
