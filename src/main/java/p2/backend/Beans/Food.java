package p2.backend.Beans;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashSet;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import p2.backend.Beans.Relationships.Diet;
import p2.backend.RollBarLogger;

@Data
@NoArgsConstructor
@NodeEntity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "foodId")
public class Food {

    @Id
    @GeneratedValue
    private Long foodId;

    private String foodName;

    private int amount;

    private String nextDelivery;

    private String notes;

   @Relationship(type = "EATS", direction = Relationship.INCOMING)
   Set<Animal> animals = new HashSet<>();

    public Food(String foodName, int amount, String nextDelivery, String notes) {
        this.foodName = foodName;
        this.amount = amount;
        this.nextDelivery = nextDelivery;
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("foodName",foodName)
                    .put("amount",amount)
                    .put("nextDelivery",nextDelivery)
                    .put("notes",notes);
            JSONArray animalArray = new JSONArray();
            this.animals.forEach(animal -> {
                JSONObject animalFood = new JSONObject();
                try {
                    animalFood.put("animalId",animal.getAnimalId());
                    animalFood.put("animalName",animal.getAnimalName());
                } catch (JSONException e) {
                    RollBarLogger.errorMessage(e,"Failed to create animal JSON array in "+ this.getClass().getSimpleName());
                }
                animalArray.put(animalFood);
            });
            json.put("Animal",animalArray);
        } catch (JSONException e) {
            RollBarLogger.error(e);
        }
        return json.toString();
    }

}
