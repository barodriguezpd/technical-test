package es.inditex.prices.exception;

import org.springframework.http.HttpStatus;

/**
 * Main Exception for Microservice
 * @author Benjamin Rodriguez
 *
 */
public class MainException extends Throwable {

    private static final long serialVersionUID = -1873807057778442269L;

    /**
     * @param message
     */
    public MainException(String message) {
        super(message);
    }

    /**
     * @return
     */
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
