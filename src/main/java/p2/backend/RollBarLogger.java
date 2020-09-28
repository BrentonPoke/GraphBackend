package p2.backend;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

import com.rollbar.notifier.Rollbar;

public class RollBarLogger {
  static Rollbar rollbar;
  public RollBarLogger (){
    rollbar =Rollbar.init(withAccessToken("ace12982e3e546f39847979667d97939").environment("production")
        .codeVersion("1.2.1").build());
  }
  public static void errorMessage(Exception e, String message){
    rollbar.error(e,message);
  }
  public static void error(Exception e){
    rollbar.error(e);
  }
  public static void info(Exception e){
    rollbar.info(e.getMessage());
  }
  
}
