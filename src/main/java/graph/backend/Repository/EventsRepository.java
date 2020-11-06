package graph.backend.Repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Events;

@Repository
public interface EventsRepository extends Neo4jRepository<Events, Long> {
	@Query("MATCH (event:Events {name:{eventName}}), (emp:Employee {username:{empname}}) CREATE (emp)-[:PRESENTS]->(event)")
	void assignEventToEmployee(@Param("eventName") String event, @Param("empname") String emp);
}
