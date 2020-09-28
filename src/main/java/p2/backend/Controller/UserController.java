package p2.backend.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rollbar.notifier.Rollbar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import p2.backend.Beans.Employee;
import p2.backend.Service.EmployeeService;
import p2.backend.security.SecurityConstants;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

@RestController
@RequestMapping("/users")
public class UserController {
	private EmployeeService employeeService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private Logger log;
	Rollbar rollbar;

	@PostConstruct
	public void initialize() {
		rollbar = Rollbar.init(withAccessToken("ace12982e3e546f39847979667d97939").environment("production")
				.codeVersion("1.2.1").build());
	}

	@Autowired
	public UserController(EmployeeService employeeService ,
						  BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.employeeService = employeeService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/user")
	public @ResponseBody ResponseEntity<String> user(@RequestBody Employee user){
		Employee emp = employeeService.byUsername(user.getUsername());
		return new ResponseEntity<>(emp.toString(),HttpStatus.OK);
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Employee user) {
		System.out.println(user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		employeeService.saveEmployee(user);

	}

	@PostMapping("/signin")
	public @ResponseBody ResponseEntity<String> signIn(@RequestBody Employee user) {
		System.out.println(user.toString());
		Employee emp = employeeService.byUsername(user.getUsername());
		if (bCryptPasswordEncoder.matches(user.getPassword(), emp.getPassword())) {
			try {
				Algorithm algorithmHS = Algorithm.HMAC512(SecurityConstants.SECRET);
				String token = JWT.create()
						.withAudience("manager") //"Audience" is the means by which users are organized into groups
						.withIssuer("Zootropolis") //Should be the name of the site or service.
						.withSubject(String.valueOf(emp.getEmployeeId())) //Subject is the user, typically by name or ID. Here, it is ID.
						.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
						.sign(algorithmHS);
				return new ResponseEntity<>(token, HttpStatus.OK);

			} catch (UnsupportedEncodingException e) {
				rollbar.error(e.getMessage());
			}

		}
		rollbar.error("There was an issue with authentication.");
		return new ResponseEntity<String>("There was an issue with authentication.", HttpStatus.FORBIDDEN);
	}

}
