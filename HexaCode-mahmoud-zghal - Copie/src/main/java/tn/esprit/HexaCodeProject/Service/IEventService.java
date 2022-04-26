package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import tn.esprit.HexaCodeProject.Entity.Event;

public interface IEventService {

	void addEvent(Event e);

	Event UpdateEvent(Event e,Long id);
	
	void deleteEvent(Long id);
	
	List<Event> retrieveAllEvents();
	
	Event OverralEventRating(Long idEvent);
	
	List GetEventsCalendar();

}
