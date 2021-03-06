package graph.backend.Beans;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import graph.backend.RollBarLogger;
import java.util.HashSet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@EqualsAndHashCode
@NodeEntity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "animalId")
public class Animal {
    @Id
    @GeneratedValue
    private Long animalId;

    private String animalName;

    private String scientificName;

    private String funFact;

    private String summary;

    private Integer numOfAnimal;

    private Integer tracking;

    private String notes;

    @Relationship(type = "EATS")
    private Set<Food> food = new HashSet<>();
    @Relationship(type = "FEEDS", direction = Relationship.INCOMING)
    private Set<Employee> employees = new HashSet<>();

    @Relationship(type = "LOCATED_AT")
    private Coordinates site;

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, String notes) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.notes = notes;
    }

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, String notes, Set<Food> food) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.notes = notes;
        this.food = food;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
            json.put("animalName",this.animalName)
                    .put("scientificName",scientificName)
                    .put("funFact",funFact)
                    .put("summary",summary)
                    .put("numOfAnimal",numOfAnimal)
                    .put("tracking",tracking)
                    .put("notes",notes);
        
        return json.toString();
    }
}
