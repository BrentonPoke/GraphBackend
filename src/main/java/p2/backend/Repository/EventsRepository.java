package p2.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Events;

@Repository
public interface EventsRepository extends Neo4jRepository<Events, Long> {

}
