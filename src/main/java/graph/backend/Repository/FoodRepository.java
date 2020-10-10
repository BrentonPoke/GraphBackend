package graph.backend.Repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Food;

@Repository
public interface FoodRepository extends Neo4jRepository<Food, Long> {
  @Query("MATCH (animal:Animal {animalName:{animal}}), (food:Food {foodName:{food}}) CREATE (animal)-[:EATS]->(food)")
  void assignFoodToAnimal(@Param("animal") String animalName, @Param("food")String foodName);
}
