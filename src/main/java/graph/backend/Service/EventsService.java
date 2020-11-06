package graph.backend.Service;

import graph.backend.Beans.Employee;
import graph.backend.Beans.QueryObjects.AssignEventQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import graph.backend.Beans.Events;
import graph.backend.Repository.EventsRepository;

@Service
public class EventsService {
	
	private EventsRepository eventsRepository;
	
	@Autowired
	public EventsService(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}
	
	public void assignEventToEmployee(AssignEventQuery query) {
    eventsRepository.assignEventToEmployee(query.getEventName(), query.getUsername());
	}
	
	public Iterable<Events> listOfEvents() {
		return eventsRepository.findAll();
	}
	
	public void saveEvent(Events save) {
		eventsRepository.save(save);
	}
	
	public void deleteEvent(Events delete) {
		eventsRepository.delete(delete);
	}
	
	
}
