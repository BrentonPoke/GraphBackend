package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Animal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AssignFoodQuery {
  String foodName;
  String animalName;
  
  @Singular
  Set<Animal> animals;
}
