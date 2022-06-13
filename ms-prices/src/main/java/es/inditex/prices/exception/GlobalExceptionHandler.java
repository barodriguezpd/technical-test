package es.inditex.prices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Benjamin Rodriguez
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public static ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorContent errorContent = new ErrorContent(ex.getMessage(),
            request.getDescription(false));
        if (ex.getCause() instanceof MainException) {
            return mainException((MainException)ex.getCause(), request);
        }
        MsPricesError error = new MsPricesError(errorContent);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MainException.class)
    public static ResponseEntity<?> mainException(MainException ex,
        WebRequest request) {
        ErrorContent errorContent = new ErrorContent(ex.getMessage(),
            request.getDescription(false));
        MsPricesError error = new MsPricesError(errorContent);
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
