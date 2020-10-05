package graph.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@Getter
@Setter
@NodeEntity
public class Location {

    @Id
    @GeneratedValue
    private Long locationId;

    private Double latitude;

    private Double longitude;

   @Relationship(type = "LOCATED_AT", direction = Relationship.INCOMING)
   Animal animal;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("id",locationId)
                .put("latitude",latitude)
                .put("longitude",longitude);
        return json.toString();
    }
}
