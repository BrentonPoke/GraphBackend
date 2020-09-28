package p2.backend.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.rollbar.notifier.Rollbar;
import java.time.LocalTime;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandlerController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        final Rollbar rollbar = new Rollbar(withAccessToken("ace12982e3e546f39847979667d97939")
                .environment("production").handleUncaughtErrors(true).build());
        rollbar.error(e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp",LocalTime.now());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}