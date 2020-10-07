package graph.backend.Beans.Relationships;

import graph.backend.Beans.Coordinates;
import graph.backend.Beans.Location;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
@RelationshipEntity(type = "WITHIN")
public class Area {
  @StartNode
  Coordinates coordinates;
  
  @EndNode
  Location location;

}
