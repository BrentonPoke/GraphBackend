package graph.backend.Repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Coordinates;

@Repository
public interface CoordinateRepository extends Neo4jRepository<Coordinates, Long> {
  @Query("MATCH (coord:Coordinates {latitude:{lat}}), (coord:Coordinates {longitude:{long}}), (loc:Location {name:{name}}) CREATE (coord)-[:WITHIN]->(loc)")
  void assignCoordinatesToLocation(@Param("lat") Double lat, @Param("long") Double lon, @Param("name") String name);
}
