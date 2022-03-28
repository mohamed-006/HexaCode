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
import tn.esprit.hexacode.Entity.Reservation;
import tn.esprit.hexacode.repository.EventRepository;
import tn.esprit.hexacode.service.IReservationService;

@RequestMapping("/reservation")
@org.springframework.web.bind.annotation.RestController
public class ReservationController {
	
	@Autowired
	IReservationService iReservationService ;
	
	@Autowired
	EventRepository eventRepository ;
	
	@PostMapping("/add-reservation/{event-id}")
	@ResponseBody
	// http://localhost:8089/SpringMVC/reservation/add-reservation/{event-id}
	public Reservation addReservation(@RequestBody Reservation r,@PathVariable("event-id") long id ){
		Event event = eventRepository.findById(id).get();    
	
		int nb = event.getNbPartipants() -1;
	    event.setNbPartipants(nb);
		return iReservationService.addReservation(r);
	}
	
	// http://localhost:8089/SpringMVC/reservation/retrieve-all-reservation
	@GetMapping("/retrieve-all-reservation")
	@ResponseBody
	public List<Reservation> RetrieveAllReservation(){
		List<Reservation> reservation = iReservationService.RetrieveAllReservation();
		return reservation ;
	}
	
	// http://localhost:8089/SpringMVC/reservation/retrieve-reservation/{reservation-id}
	@GetMapping("/retrieve-reservation/{reservation-id}")
	@ResponseBody
	public Reservation retrievReservation(@PathVariable("reservation-id") long id){
			return iReservationService.retrieveReservation(id);
	}
	
	//localhost:8089/SpringMVC/reservation/modify-reservation
	@PutMapping("/modify-reservation")
	@ResponseBody
	public Reservation modifyReservation (@RequestBody Reservation r){
		return iReservationService.modifyReservation(r);
	}
	
	//localhost:8089/SpringMVC/reservation/delete-reservation/{reservation-id}
	@DeleteMapping("/delete-reservation/{reservation-id}")
	@ResponseBody
	void deletereservation(@PathVariable("reservation-id") long id){
		iReservationService.deleteReservation(id);
	}
	

}

