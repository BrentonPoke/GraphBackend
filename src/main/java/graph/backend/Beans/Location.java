package graph.backend.Beans;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Id;

@Setter
@Getter
@NodeEntity
public class Location {
  
  @Id
  @GeneratedValue
  private Long id;
  
  private String name;
  
  public Location(String name) {
    this.name = name;
  }
}
