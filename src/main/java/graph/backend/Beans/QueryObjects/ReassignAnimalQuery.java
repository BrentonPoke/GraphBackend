package graph.backend.Beans.QueryObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReassignAnimalQuery extends AssignAnimalQuery {
String oldEmpUsername;
}
