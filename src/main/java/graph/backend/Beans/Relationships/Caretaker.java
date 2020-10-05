package graph.backend.Beans.Relationships;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import graph.backend.Beans.Animal;
import graph.backend.Beans.Employee;

@Setter
@Getter
@RelationshipEntity(type = "FEEDS")
public class Caretaker {
  @StartNode
  Employee employee;

  @EndNode
  Animal animal;
}
