package graph.backend.Service;

import graph.backend.Beans.QueryObjects.AssignLocationQuery;
import graph.backend.Repository.CoordinateRepository;
import graph.backend.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import graph.backend.Beans.Coordinates;

@Service
public class CoordinateService {

    private CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }
    
    public void assignCoordinatesToLocation(AssignLocationQuery query){
    this.coordinateRepository.assignCoordinatesToLocation(
        query.getCoordinates().getLatitude(),query.getCoordinates().getLongitude(), query.getLocationName());
    }

    public Iterable<Coordinates> listofCoordinates() {
        return coordinateRepository.findAll();
    }
}

