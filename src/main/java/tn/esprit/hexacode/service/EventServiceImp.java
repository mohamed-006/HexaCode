package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Event;
import tn.esprit.hexacode.repository.EventRepository;
@Service
public class EventServiceImp implements IEventService{

	@Autowired
	EventRepository eventRepository ;
	
	
	@Override
	public Event addEvent(Event e) {
		
		return eventRepository.save(e);
	}
	
	
	@Override
	public List<Event> RetrieveAllEvents() {
		List<Event> event =eventRepository.findAll();
		return event;
	}

	@Override
	public Event retrieveEvent(Long id) {
		Event event = eventRepository.findById(id).orElse(null);
		return event;
	}

	@Override
	public Event modifyEvent(Event e) {
		
		return eventRepository.save(e);
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
		
	}

}
