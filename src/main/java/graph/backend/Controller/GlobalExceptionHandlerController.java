package graph.backend.Controller;


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
   RollBarLogger rollbar;
    
    @Autowired
    public GlobalExceptionHandlerController(RollBarLogger rollbar) {
        this.rollbar = rollbar;
    }
    @ExceptionHandler(value
        = { IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class})
    protected ResponseEntity<Object> handleConflict(
        RuntimeException ex, WebRequest request) {
      rollbar.rollbar().error(ex);
        String bodyOfResponse = ex.getCause().getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
            new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
}