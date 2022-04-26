package tn.esprit.HexaCodeProject.Service;

import java.util.Set;

import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.Participant;

public interface IParticipantService {
	Participant participate(Long idUser,Long idEvent);
	
	void Unparticipate(Long id);
	
	Participant sendInvitation(Long idUser,Long idEvent);
	
	Participant AcceptInvitation(Long idPart);
	
	void DeclineInvitation(Long id);
	
	void RateEvent(Long idPart,int rate);

	Set<Participant>RecieveInvitation(Long idUser);
}
