package es.inditex.prices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author paradigma
 */

/**
 * @author paradigma
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends MainException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * HttpStatus.NOT_FOUND
     */
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
