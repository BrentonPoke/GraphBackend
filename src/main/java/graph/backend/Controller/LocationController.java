package graph.backend.Controller;

import graph.backend.Beans.Employee;
import graph.backend.Beans.Events;
import graph.backend.Beans.QueryObjects.AssignLocationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Coordinates;
import graph.backend.Service.CoordinateService;

@CrossOrigin
@RestController
@RequestMapping("/Location")
public class LocationController {
	
	private CoordinateService coordinateService;
	
	@Autowired
	public LocationController(CoordinateService locationService) {
		this.coordinateService = locationService;
	}
	
	@RequestMapping
	public Iterable<Coordinates> locationList() {
		return coordinateService.listofCoordinates();
	}
	
	@PutMapping("/assign")
	public void assignLocation(@RequestBody AssignLocationQuery query) {
		coordinateService.assignCoordinatesToLocation(query);
	}
	
}
