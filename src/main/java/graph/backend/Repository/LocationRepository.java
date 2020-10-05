package graph.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Location;

@Repository
public interface LocationRepository extends Neo4jRepository<Location, Long> {

}
