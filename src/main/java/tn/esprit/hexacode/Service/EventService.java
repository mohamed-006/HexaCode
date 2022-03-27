package tn.esprit.hexacode.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.hexacode.Entity.Event;

import java.util.List;
public interface EventService {

   // public Event create(Event eventData);
    public Event save( Event event);

    public Event updateEvent(Event event, Long eventid );

   // public void delete(Long eventid);


    void delete(Long eventid);

    public Event getEvent(Long eventid);

    public List getAllEvents();

    public void cancelRegistration(Long eventid,Long userid);

    public List getRegisteredEvents(Long userid);

    public boolean isAlreadyRegistered(Long userid,Long eventid);
}
