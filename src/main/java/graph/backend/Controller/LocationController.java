package graph.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Coordinates;
import graph.backend.Service.CoordinateService;

@CrossOrigin
@RestController
@RequestMapping("/Location")
public class LocationController {

    private CoordinateService coordinateService;

    @Autowired
    public LocationController(CoordinateService locationService){
        this.coordinateService =locationService;
    }

    @RequestMapping
    public Iterable<Coordinates> locationList(){
        return coordinateService.listofCoordinates();
    }

}
