package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.EventComment;

public interface IEventComment  {
	void addEventComment(EventComment ec,Long idEvent);
	
	void updateEventComment(EventComment ec);
	
	void deleteEventeComment(long id);
	
	List<EventComment> retrieveAllEventComments();
	
	
}
