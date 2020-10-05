package graph.backend.security;

public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";
	public static final String SIGN_IN_URL = "/users/signin";
	public static final String ASSIGN_ANIMAL_URL = "/users/assignAnimal";
	public static final String EVENTS = "/Events/";
	public static final String ANIMALS = "/Animal/";
	public static final String LOCATION = "/Location/";
}
