package tn.esprit.HexaCodeProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.HexaCodeProject.Entity.Event;

import tn.esprit.HexaCodeProject.Service.IEventService;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "Event")
public class EventRestController {
	@Autowired
	private IEventService eventServ;
	

	
	@PostMapping (value ="/add_event")
	public void addEvent(@RequestBody Event e){
		eventServ.addEvent( e);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value="/update_event/{id}")
	public Event updateEvent(@RequestBody Event e,@PathVariable("id") long id){
		
		return (eventServ.UpdateEvent(e,id));
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/delete_event/{id}")
	public void deleteEvent(@PathVariable("id") long id){
		eventServ.deleteEvent(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_all_events")
    @ResponseBody
    public List<Event> retrieveAllEvents() {
        List<Event> events = eventServ.retrieveAllEvents();
        System.out.println(events);
        return events;
    }
	
	@PutMapping(value="/EventRationg")
	public Event OverralEventRating(Long idEvent){
		
		Event e=eventServ.OverralEventRating(idEvent);
		return e;
		
	}
	
	@GetMapping(value="/GetCalendar")
	public List GetCalendar(){
		List L = eventServ.GetEventsCalendar();
		return (L);
	}
	

}
