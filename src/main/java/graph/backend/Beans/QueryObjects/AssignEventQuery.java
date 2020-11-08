package graph.backend.Beans.QueryObjects;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AssignEventQuery {
	String eventName, username;
	
	@Singular
	Set<String> empUsernames;
	
}
