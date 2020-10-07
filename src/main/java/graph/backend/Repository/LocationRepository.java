package graph.backend.Repository;

import graph.backend.Beans.Coordinates;
import graph.backend.Beans.Location;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends Neo4jRepository<Location,Long> {

}
