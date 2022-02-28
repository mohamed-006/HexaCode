package tn.esprit.hexacode.service;

import java.util.List;


import tn.esprit.hexacode.Entity.Event;

public interface IEventService {
	List<Event> RetrieveAllEvents ();
	Event addEvent (Event e); 
	Event retrieveEvent (Long id );
	Event modifyEvent (Event e) ;
	 void deleteEvent (Long id) ;

}
