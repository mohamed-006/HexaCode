package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import tn.esprit.HexaCodeProject.Entity.Interest;

public interface IInterestService {

	 void addIntrest(Interest in);
	
	 void updateIntrest(Interest in);
	 
	 void deleteIntrest(Long id);
	 
	 void Follow(Long idUser ,Long idIntrest);
	 
	 void Unfollow(Long id);
	 
	 List<Interest> GetAllFollows(Long idUser);

}
