package graph.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//import javax.persistence.*;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class Coordinates {

    @Id
    @GeneratedValue
    private Long id;

    private Double latitude;

    private Double longitude;
    
    @Relationship(type = "WITHIN")
    private Location location;

   @Relationship(type = "LOCATED_AT", direction = Relationship.INCOMING)
   Animal animal;

    public Coordinates(Double latitude, Double longitude, Location location) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
    }
    
  public Coordinates(Double latitude, Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
    }
    

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("id",id)
                .put("latitude",latitude)
                .put("longitude",longitude)
                .put("location",location.getName())
                .putPOJO("animal",animal);
        return json.toString();
    }
}
