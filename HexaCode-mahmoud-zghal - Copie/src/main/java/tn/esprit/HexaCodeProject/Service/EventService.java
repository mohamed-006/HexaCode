package tn.esprit.HexaCodeProject.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.InvitationStatus;
import tn.esprit.HexaCodeProject.Entity.Participant;
import tn.esprit.HexaCodeProject.Repository.IEventRepository;
import tn.esprit.HexaCodeProject.Repository.IParticipantRepository;

@Service
public class EventService implements IEventService {
	
	@Autowired
	IEventRepository EventRepo ;
	
	@Autowired
	IParticipantRepository particpantRepo;
	
	
	public void addEvent(Event e){
		EventRepo.save(e);
	}
	
	public Event UpdateEvent(Event e ,Long id){
		Event e1 = EventRepo.findById(id).orElse(null);
		e1=e;
		e1.setId(id);
		EventRepo.save(e1);
		return (e1);
	}
	
	public void deleteEvent(Long id){
		EventRepo.deleteById(id);
	}
	
    public List<Event> retrieveAllEvents() {
		
		List<Event> events =  EventRepo.findAll();
		return events;
	}
    
    
    public Event OverralEventRating(Long idEvent){
    	Event event=EventRepo.findById(idEvent).orElse(null);
    	Set<Participant> x = event.getParticipants();
    	
    	double moy=0;
    	double total=0;
    	for (Participant i : x){
    		int r = i.getRating();
    		total=total+r;
    		moy=total/x.size();
    		 
    	}
    	event.setNote(moy);
    	EventRepo.save(event);
    	return event;
    	
    }
    
    public List GetEventsCalendar(){
    	List L = EventRepo.getCalendar();
    	
    	
    	
    	return (L);
    }
}
    
    
    
    
    
    




	
	
	
	
	


