package graph.backend.Repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import graph.backend.Beans.Employee;

@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
    @Query("MATCH (n:Employee) where n.username = $username return n")
    Employee findEmployeeByUsername(@Param("username") String username);
    @Query("MATCH (n:Employee) where n.id = $id return n")
    Employee findEmployeeByEmployeeId(@Param("id") Long id);
}
