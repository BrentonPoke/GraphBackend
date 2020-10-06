package graph.backend;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.rollbar.spring.webmvc.RollbarSpringConfigBuilder;

@Configuration()
@EnableWebMvc
@ComponentScan({
    "graph.backend",
    "com.rollbar.spring",
})
public class RollBarLogger {
  @Value("ace12982e3e546f39847979667d97939")
  private String accessToken;

  @Value("production")
  private String environment;
  
  /**
   * Register a Rollbar bean to configure App with Rollbar.
   */
  @Bean
  public Rollbar rollbar() {
    return new Rollbar(getRollbarConfigs());
  }
  
  private Config getRollbarConfigs() {
    
    // Reference ConfigBuilder.java for all the properties you can set for Rollbar
    return RollbarSpringConfigBuilder.withAccessToken(this.accessToken)
        .environment(this.environment)
        .build();
  }
  
}
