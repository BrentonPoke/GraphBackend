package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Animal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignAnimalQuery {
String username;
String animalName;
  @Singular
  Set<Animal> animals;
}
