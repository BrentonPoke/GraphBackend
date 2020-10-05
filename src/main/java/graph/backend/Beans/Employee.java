package graph.backend.Beans;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

import com.fasterxml.jackson.annotation.*;
import com.rollbar.notifier.Rollbar;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Getter
@Setter
@NodeEntity
@JsonIdentityInfo(
        generator=ObjectIdGenerators.PropertyGenerator.class,
        property="employeeId")
public class Employee {
    @Id
    @GeneratedValue
    private Long employeeId;

    private String firstName;

    private String lastName;
    
    private String username;

    private String password;

    private Integer role;
    

   @Relationship(type = "FEEDS")
    private Set<Animal> animals;
   public void addAnimal(Animal animal){
     this.animals.add(animal);
   }
   
   public Employee(){
     this.animals = new HashSet<>();
   }
   
   public Employee(String username, String password){
     this.username = username;
     this.password = password;
   }
   
    public Employee(String firstName, String lastName, String username, String password, Integer role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Employee(String firstName, String lastName, String username, String password, Integer role, Set<Animal> animals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.animals = animals;

    }
    

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("firstName",firstName)
                    .put("lastName",lastName)
                .put("employeeId",employeeId)
                    .put("username",username)
                    .put("role",role);
        } catch (JSONException e) {
            Rollbar rollbar= Rollbar.init(withAccessToken("ace12982e3e546f39847979667d97939").environment("production")
                .codeVersion("1.2.1").build());
            rollbar.error(e.getMessage());
        }
        return json.toString();

    }
}
