package net.etfbl.webshop.exceptions;

import org.springframework.http.HttpStatus;

// Statusni kod 403
public class ForbiddenException extends HttpException {
    public ForbiddenException() {
        super(HttpStatus.FORBIDDEN, null);
    }

    public ForbiddenException(Object data) {
        super(HttpStatus.FORBIDDEN, data);
    }
}
