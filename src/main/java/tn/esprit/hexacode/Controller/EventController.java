package tn.esprit.hexacode.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

//
//    @Autowired
//    EventService eventService;
//    @Autowired
//    EventServiceImpl service;
//
//    @RequestMapping(value="/registered", method= RequestMethod.POST)
//    public Event save(@RequestBody Event event){
//       return  service.save(event);
//    }
//    @RequestMapping(value="/delete/{eventid}", method= RequestMethod.DELETE)
//    public void delete(@PathVariable Long eventid){
//        service.delete(eventid);
//    }
//
//    @RequestMapping(value="/updateEvent/{eventid}", method= RequestMethod.PUT)
//    public Event updateEvent(@RequestBody Event event, @PathVariable Long eventid ){
//        return service.updateEvent(event,eventid);
//    }
//    @RequestMapping(value="/getEvent/{eventid}", method= RequestMethod.GET)
//    public Event getEvent(@PathVariable Long eventid){
//        return service.getEvent(eventid);
//    }
//
//
//    private static final Logger logger = LoggerFactory.getLogger(EventController.class);
//
////    @RequestMapping(value="/event", method= RequestMethod.POST)
////    public String event( HttpServletRequest request,Model model) {
////        String returnPage ="welcome";
////        String action = request.getParameter("action");
//        logger.info("Action is ::"+action);
//        if("RedirectCreate".equals(action)){
//            return "CreateEvent";
//        }
//        else if("Create".equals(action)){
//            Event eventData = new Event();
//            eventData.setName(request.getParameter("name"));
//            eventData.setDescription(request.getParameter("description"));
//            eventData.setLocation(request.getParameter("location"));
//            eventData.setTotalseats(Long.valueOf(request.getParameter("totalseats")));
//            eventData.setRegseats(0L);
//            logger.info("Date is ::"+request.getParameter("time"));
//            eventData.setTime(new Date());
//            eventService.save(eventData);
//            request.setAttribute("response", "Event is created successfully.");
//            return "CreateEvent";
//        }
//        else if("Edit".equals(action)){
//            updateEvent(request,model);
//            request.setAttribute("response", "Event is updated successfully.");
//            return "UpdateEvent";
//        }
//        else if("Delete".equals(action)){
//            String deleteid = request.getParameter("deletedItems");
//            Long userid = ((User)request.getSession().getAttribute("user")).getUserid();
//
//            eventService.cancelRegistration(Long.valueOf(deleteid), userid);
//            eventService.delete(Long.valueOf(deleteid));
//            request.setAttribute("response", "Event is deleted successfully.");
//            return redirectSearch(model);
//
//        }
//        else if("Search".equals(action)){
//            return redirectSearch(model);
//        }
//        else if("RedirectUpdate".equals(action)){
//            String updateId = request.getParameter("updateItem");
//            Event event = eventService.getEvent(Long.valueOf(updateId));
//            request.setAttribute("event",event);
//            return "UpdateEvent";
//        }
//        return returnPage;
//    }
//
//    private String redirectSearch(Model model){
//        List<Event> eventList = eventService.getAllEvents();
//        System.out.println("EventList::"+eventList);
//        model.addAttribute("eventList",eventList);
//        model.addAttribute("size",eventList.size());
//        return "ListEvent";
//    }
//
//    private void updateEvent( HttpServletRequest request,Model model){
//
//        String id = request.getParameter("eventid");
//        Event event = eventService.getEvent(Long.valueOf(id));
//
//        String newName= request.getParameter("name");
//        String description= request.getParameter("description");
//        String totalSeats= request.getParameter("totalseats");
//        String location= request.getParameter("location");
//        String time= request.getParameter("time");
//
//        event.setName(newName);
//        event.setDescription(description);
//        event.setTotalseats(Long.valueOf(totalSeats));
//        event.setLocation(location);
//        event.setTime(new Date());
//        request.setAttribute("event",event);
//        //eventService.updateEvent(event,eventid);
//    }
}
