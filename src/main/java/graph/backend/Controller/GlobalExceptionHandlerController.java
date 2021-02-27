package graph.backend.Controller;


import com.rollbar.notifier.Rollbar;
import graph.backend.RollBarLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
   Rollbar rollbar;
    
    @Autowired
    public GlobalExceptionHandlerController(Rollbar rollbar) {
        this.rollbar = rollbar;
    }
    @ExceptionHandler(value
        = { IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class})
    protected ResponseEntity<Object> handleConflict(
        RuntimeException ex, WebRequest request) {
      rollbar.error(ex);
        String bodyOfResponse = ex.getCause().getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
            new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
}