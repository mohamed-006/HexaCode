package tn.esprit.hexacode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import tn.esprit.hexacode.Entity.Event;
import tn.esprit.hexacode.service.IEventService;



@RequestMapping("/Event")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	IEventService iEventService ;
	
	@PostMapping("/add-event")
	@ResponseBody
	// http://localhost:8089/SpringMVC/Event/add-event
	public Event addEvent(@RequestBody Event e ){
		return iEventService.addEvent(e);
	}
	// http://localhost:8089/SpringMVC/Event/retrieve-all-events
	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> RetrieveAllEvents(){
		List<Event> event = iEventService.RetrieveAllEvents();
		return event ;
	}
	// http://localhost:8089/SpringMVC/Event/retrieve-Event/{Event-id}
	@GetMapping("/retrieve-Event/{Event-id}")
	@ResponseBody
	public Event retrieveEvent(@PathVariable("Event-id") long id){
		return iEventService.retrieveEvent(id);
	}
	//localhost:8089/SpringMVC/Event/modify-Event
	@PutMapping("/modify-Event")
	@ResponseBody
	public Event modifyEvent (@RequestBody Event e ){
		return iEventService.modifyEvent(e);
	}

	//localhost:8089/SpringMVC/Event/delete-Event/{Event-id}
	@DeleteMapping("/delete-Event/{Event-id}")
	@ResponseBody
	void deleteEvent(@PathVariable("Event-id") long id){
		iEventService.deleteEvent(id);
	}
}
