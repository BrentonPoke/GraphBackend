package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Animal;
import java.util.Set;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class AssignAnimalQuery {
String username;
String animalName;
  @Singular
  Set<Animal> animals;
}
