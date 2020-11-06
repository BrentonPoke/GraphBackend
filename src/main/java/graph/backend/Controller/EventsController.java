package graph.backend.Controller;


import com.sun.org.apache.xerces.internal.util.HTTPInputSource;
import graph.backend.Beans.Employee;
import graph.backend.Beans.QueryObjects.AssignEventQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Events;
import graph.backend.Service.EventsService;

@CrossOrigin
@RestController
@RequestMapping("/Events")
public class EventsController {

    private EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService){
        this.eventsService = eventsService;
    }
    @RequestMapping("/")
    public Iterable<Events> EventList(){
        return eventsService.listOfEvents();
    }
    
    @PutMapping("assignEvent")
    public HttpStatus assignEventToEmployee(@RequestBody AssignEventQuery query) {
        eventsService.assignEventToEmployee(query);
        return HttpStatus.CREATED;
    }

    @PostMapping("/save")
    public void saveEvent(@RequestBody Events save){
        eventsService.saveEvent(save);
    }

    @PostMapping("/delete")
    public void deleteEvent(@RequestBody Events delete){
        eventsService.deleteEvent(delete);
    }
}
