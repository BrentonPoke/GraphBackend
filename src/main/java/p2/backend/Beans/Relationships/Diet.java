package p2.backend.Beans.Relationships;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Food;

@Setter
@Getter
@RelationshipEntity(type = "EATS")
public class Diet {

  private Collection<String> foods;

  @StartNode
  Animal animal;

  @EndNode
  Food food;
}
