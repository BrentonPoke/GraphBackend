package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Animal;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
public class AssignAnimalQuery {
String username;
String animalName;
  @Singular
  Set<Animal> animals;
}
