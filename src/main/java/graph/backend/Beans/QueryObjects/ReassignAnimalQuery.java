package graph.backend.Beans.QueryObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReassignAnimalQuery extends AssignAnimalQuery {
String oldEmpUsername;
}
