package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.hexacode.Entity.Collaborator;
import tn.esprit.hexacode.Entity.Rating;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.repository.CollaboratorRepository;
import tn.esprit.hexacode.repository.RatingRepository;
import tn.esprit.hexacode.repository.UserRepository;
@Service
public class RatingServiceImp  implements IRatingService{

	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CollaboratorRepository  collaboratorRepository ;
	
	
	@Override
	public Rating findRatingByUserAndCollaborator(Long userId, Long collabId) {
		
		return ratingRepository.findRatingByUserAndCollaborator(userId, collabId);
	}

	@Override
	public Rating addRating(Rating rating, Long userId,Long collabId) {
		User u = userRepository.findById(userId).orElse(null);		
		Collaborator c=collaboratorRepository.findById(collabId).orElse(null);
		
		rating.setUser(u);		
		rating.setCollaborator(c);		
		
		return ratingRepository.save(rating);
		
	}
	
	
	@Override
	public List<Rating> findRatingBycollaborator (Long collabId) {
		
		return ratingRepository.findRatingBycollaborator(collabId);
	}

	@Override
	public int calculMoyRating(Long collabId) {
		Collaborator collaborator = collaboratorRepository.findById(collabId).get() ;
		int rating=0;
		int max =collaborator.getRate();
	
		 if(ratingRepository.findRatingBycollaborator(collabId) != null && ratingRepository.findRatingBycollaborator(collabId).size() != 0 )  {
			 System.out.println(ratingRepository.findRatingBycollaborator(collabId));
			 for (Rating rte :ratingRepository.findRatingBycollaborator(collabId) ){
				 rating += rte.getStars() ;		 
			  
			 }
			  rating= rating/ratingRepository.findRatingBycollaborator(collabId).size();			  		  
		 }
//		 collaborator.setRate(rating);
//		 for (Collaborator collab :collaboratorRepository.findAll() ){
//			 if (collab.getRate()>max)
//				 max=collab.getRate();
//		 }
		 
		 
		 
		return rating;
	}
		
		public String meilleurCollab(){
			String nom = "" ;
			Collaborator collaborator = collaboratorRepository.findfirstCollaborator() ;
			List<Collaborator> c = collaboratorRepository.findAll();
			int max =collaborator.getRate();
		
			for (Collaborator collab : c ){
					if (collab.getRate()>max){
					max=collab.getRate();
					nom = collab.getNom() ;
				 }
				 
				
			}
			
			return "le meuilleur collaborateur est ** "+ nom + " **"  ; 
	}

	

	

}
