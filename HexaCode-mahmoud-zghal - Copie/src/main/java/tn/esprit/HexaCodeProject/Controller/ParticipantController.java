package tn.esprit.HexaCodeProject.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.Participant;
import tn.esprit.HexaCodeProject.Service.IParticipantService;

@RestController

@RequestMapping(value = "Participant")
public class ParticipantController {
	
	@Autowired
	IParticipantService partServ;
	
	
	@PostMapping(value ="/participate/{idEvent}/{idUser}")
	public Participant participate(@PathVariable("idEvent")Long idEvent,@PathVariable("idUser")Long idUser){
		Participant p=partServ.participate(idUser, idEvent);
		return p;
	}
	
	@DeleteMapping(value ="/unparticipate/{id}")
	public void unparticipate(@PathVariable ("id")long id){
		partServ.Unparticipate(id);
	
	}
	
	@PostMapping(value ="/sendInvi/{idEvent}/{idUser}")
	public Participant sendInvi(@PathVariable("idEvent") Long idEvent,@PathVariable("idUser")Long idUser){
		Participant p=partServ.sendInvitation(idUser, idEvent);
		return p;
	}
	
	@PutMapping(value ="/Accept/{idPart}")
	public Participant Accept(@PathVariable("idPart") Long idPart){
		Participant p=partServ.AcceptInvitation(idPart);
		return p;
	}
	
	@DeleteMapping(value ="/Decline/{id}")
	public void decline(@PathVariable ("id")long id){
		partServ.DeclineInvitation(id);
		
	}
	@PutMapping(value="/rate_event/{idPart}/{rating}")
	public void rateEvent(@PathVariable("idPart") Long idPart,@PathVariable("rating") int rate) {
	 partServ.RateEvent(idPart, rate);
		}
	
	@GetMapping(value="/rate_event/{idUser}")
	public Set<Participant> getInvite(@PathVariable("idUser") Long idUser)
	{
		
		Set<Participant> p = partServ.RecieveInvitation(idUser);
		return p;
	}
	
	
	
	
	
	
	
	
	

}
