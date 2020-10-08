package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Coordinates;
import lombok.Data;

@Data
public class AssignLocationQuery {
  String locationName;
  Coordinates coordinates;

}
