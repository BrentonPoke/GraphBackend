package graph.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Food;

@Repository
public interface FoodRepository extends Neo4jRepository<Food, Long> {
}
