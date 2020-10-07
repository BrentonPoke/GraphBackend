package graph.backend.Beans.QueryObjects;

import graph.backend.Beans.Coordinates;
import graph.backend.Beans.Location;
import lombok.Data;

@Data
public class AssignLocationQuery {
  String locationName;
  Coordinates coordinates;

}
