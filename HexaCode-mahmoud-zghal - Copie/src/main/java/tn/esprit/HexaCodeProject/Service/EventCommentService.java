package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.EventComment;
import tn.esprit.HexaCodeProject.Repository.IEventCommentRepository;
import tn.esprit.HexaCodeProject.Repository.IEventRepository;

@Service
public class EventCommentService implements IEventComment{
	
	@Autowired
	IEventCommentRepository eventCommRepo;
	@Autowired
	IEventRepository eventrepo;
	
	public void addEventComment(EventComment ec,Long idEvent){
		
		Event ev= eventrepo.findById(idEvent).orElse(null);
		
		ec.setEvent(ev);
		eventCommRepo.save(ec);
		
	}
	
	public void updateEventComment(EventComment ec){
		eventCommRepo.save(ec);
	}
	
	public void deleteEventeComment(long id){
		eventCommRepo.deleteById(id);
	}
	public List<EventComment> retrieveAllEventComments() {
		
		List<EventComment> eventComments =  eventCommRepo.findAll();
		return eventComments;
	}

	

	
	

}
