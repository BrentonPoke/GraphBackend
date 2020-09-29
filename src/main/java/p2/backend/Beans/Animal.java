package p2.backend.Beans;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import p2.backend.Beans.Relationships.Caretaker;
import p2.backend.Beans.Relationships.Diet;
import p2.backend.RollBarLogger;

@Data
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
    private Location site;


  public Animal(){

    }

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
        JSONObject json = new JSONObject();
        try {
            json.put("animalName",this.animalName)
                    .put("scientificName",scientificName)
                    .put("funFact",funFact)
                    .put("summary",summary)
                    .put("numOfAnimal",numOfAnimal)
                    .put("tracking",tracking)
                    .put("notes",notes);
        } catch (JSONException e) {
            RollBarLogger.error(e);
        }
        return json.toString();
    }
}
