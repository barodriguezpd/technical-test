package es.inditex.prices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to BadRequest
 * @author Benjamin Rodriguez
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotValidException extends MainException {

    private static final long serialVersionUID = 1727228941388629819L;

    /**
     * @param message
     */
    public NotValidException(String message) {
        super(message);
    }

    /**
     * HttpStatus.BAD_REQUEST
     */
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

