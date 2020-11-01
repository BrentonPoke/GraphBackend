package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Animal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AssignAnimalQuery {
String empUsername;
String animalName;
  @Singular
  Set<Animal> animals;
}
