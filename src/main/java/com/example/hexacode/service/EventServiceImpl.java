package tn.esprit.hexacode.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.hexacode.Entity.Event;
import tn.esprit.hexacode.Repository.EventRepository;
import tn.esprit.hexacode.dao.EventDao;

import java.util.List;

@Service
//@EnableAutoConfiguration
@Component
public class EventServiceImpl implements EventService{

    @Autowired
    EventDao eventDao;

    @Autowired
    EventRepository eventRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    @Transactional
    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public Event updateEvent(Event event, Long eventid) {
    eventRepository.findById(eventid).orElse(null);
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public void delete(Long eventid) {
        //eventRepository.delete(eventid);
       eventRepository.deleteById(eventid);
    }
    @Transactional
    @Override
    public Event getEvent(Long eventid) {
        return eventRepository.findById(eventid).orElse(null);
    }

    @Transactional
    @Override
    public List getAllEvents() {
        return eventDao.getAllEvents();
    }

    @Override
    public List getRegisteredEvents(Long userid) {
        logger.info("Going to get Registered Events.");
        return eventDao.getRegisteredEvents(userid);
    }

    @Override
    public void cancelRegistration(Long eventid,Long userid){
        try{
            logger.info("Going to cancel Registration");
            eventDao.cancelRegistration(eventid, userid);
            logger.info("Cancelation done.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAlreadyRegistered(Long userid,Long eventid){
        try{
            List<Event> userEventList=eventDao.getRegisteredEvents(userid);
            logger.info("Event List ::"+userEventList);
            if(userEventList==null || userEventList.isEmpty()){
                logger.info("EVent list is null.");
                return false;
            }
            else
            {
                for(Event event : userEventList){
                    if(event.getEventid()==eventid)
                        return true;
                }
                logger.info("No registered event found.");
            }
            return false;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return true;
        }
    }
}
