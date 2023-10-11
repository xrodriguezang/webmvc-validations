package GenericException;

import exceptions.ElementNotFoundException;
import model.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)  // Si volem donar més importància a les genèriques que no pas a les altres
public class AppRestControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler (ElementNotFoundException.class)
    public ApiError handlerNotFoundException ( ElementNotFoundException e ) {
        ApiError apiError = new ApiError(404, null);

        return apiError;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handlerMethodArgumentNotValidException (MethodArgumentNotValidException m) {
        String errorText = "";

        for (FieldError fieldError: m.getFieldErrors()) {
            errorText += fieldError.getField() + ":" + fieldError.getDefaultMessage();
        }

        ApiError error = new ApiError(1, errorText);
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler (Exception.class)
    public ApiError handlerNotFoundException ( Exception e ) {
        ApiError apiError = new ApiError(404, null);

        return apiError;
    }


}
