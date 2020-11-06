package graph.backend.Beans.Relationships;

import graph.backend.Beans.Employee;
import graph.backend.Beans.Events;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
@RelationshipEntity(type="PRESENTS")
public class Presents {
	@StartNode
	Employee employee;
@EndNode
Events event;
}
