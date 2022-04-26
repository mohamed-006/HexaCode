package tn.esprit.HexaCodeProject.Controller;

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
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.HexaCodeProject.Entity.EventComment;
import tn.esprit.HexaCodeProject.Service.IEventComment;

@RestController

@RequestMapping(value = "EventComment")
public class EventCommentRest {
	
	@Autowired
	IEventComment eventComm;
	
	@PostMapping (value ="/add_eventComment/{idEvent}")
	public void addEventComment(@RequestBody EventComment ec ,@PathVariable("idEvent") long idEvent){
		
		eventComm.addEventComment(ec,idEvent);
	}
	
	@PutMapping (value="/updateEventComment")
		
		public void updateEventComment(@RequestBody EventComment ec ){
			
			eventComm.updateEventComment(ec);
		}
	
	
	@DeleteMapping (value="/deleteEventComment")
	public void deleteEventComment(@RequestBody long id){
		
		eventComm.deleteEventeComment(id);
	}
	
	@GetMapping("/get_all_eventComments")
    @ResponseBody
    public List<EventComment> retrieveAlleventcomments() {
        List<EventComment> eventComments = eventComm.retrieveAllEventComments();
        System.out.println(eventComments);
        return eventComments;
    }
		
		
	}


