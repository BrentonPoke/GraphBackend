package graph.backend.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.rollbar.notifier.Rollbar;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    final Rollbar rollbar;
    
    @Autowired
    public GlobalExceptionHandlerController(Rollbar rollbar) {
        this.rollbar = rollbar;
    }
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleConflict(
        RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getCause().getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
            new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}