package graph.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Events;

@Repository
public interface EventsRepository extends Neo4jRepository<Events, Long> {

}
