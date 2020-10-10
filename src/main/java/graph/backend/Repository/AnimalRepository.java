package graph.backend.Repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Animal;

import java.util.Set;

@Repository
public interface AnimalRepository extends Neo4jRepository<Animal,Long> {

    Animal findAnimalByAnimalName(String name);
    @Query("MATCH (n:`Animal`) return n")
    Set<Animal> findAll();
    @Query("MATCH (animal:Animal {animalName:{animal}}), (emp:Employee {username:{employee}}) CREATE (emp)-[:FEEDS]->(animal)")
    void assignAnimalToEmployee(@Param("animal") String animal, @Param("employee") String employee);
}
