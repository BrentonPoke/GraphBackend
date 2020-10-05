package graph.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Location;
import graph.backend.Service.LocationService;

@CrossOrigin
@RestController
@RequestMapping("/Location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService =locationService;
    }

    @RequestMapping
    public Iterable<Location> locationList(){
        return locationService.listofLocations();
    }

}
