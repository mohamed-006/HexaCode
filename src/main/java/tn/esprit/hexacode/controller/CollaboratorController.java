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

import tn.esprit.hexacode.Entity.Collaborator;
import tn.esprit.hexacode.repository.CollaboratorRepository;
import tn.esprit.hexacode.service.ICollaboratorService;
import tn.esprit.hexacode.service.IRatingService;

@RequestMapping("/collaborator")
@org.springframework.web.bind.annotation.RestController
public class CollaboratorController {
	@Autowired
	CollaboratorRepository  collaboratorRepository ;
	@Autowired
	ICollaboratorService collaboratorService;
	@Autowired
	IRatingService iRatingService ;
	
	
	@PostMapping("/add-collaborator")
	@ResponseBody
	// http://localhost:8089/SpringMVC/collaborator/add-collaborator
	public Collaborator addCollaborator(@RequestBody Collaborator c ){
		return collaboratorService.addCollaborator(c);
	}

	// http://localhost:8089/SpringMVC/collaborator/retrieve-all-collaborator
			@GetMapping("/retrieve-all-collaborator")
			@ResponseBody
			public List<Collaborator> RetrieveAllCollaborator(){
				List<Collaborator> collaborator=collaboratorService.RetrieveAllCollaborator();
				return collaborator ;
			}
			
			// http://localhost:8089/SpringMVC/collaborator/retrieve-collaborator/{collaborator-id}
			@GetMapping("/retrieve-collaborator/{collaborator-id}")
			@ResponseBody
			public Collaborator retrievCollaborator(@PathVariable("collaborator-id") long id){
				return collaboratorService.retrieveCollaborator(id);
			}
			
			//localhost:8089/SpringMVC/collaborator/modify-collaborator
			@PutMapping("/modify-collaborator")
			@ResponseBody
			public Collaborator modifyCollaborator (@RequestBody Collaborator c){
				
				
				return collaboratorService.modifyCollaborator(c);
			}
			//localhost:8089/SpringMVC/collaborator/modify-collaborator-id/{collabId}
			@PutMapping("/modify-collaborator-id/{collabId}")
			@ResponseBody
			public void modifyCollaboratorbyId (@PathVariable("collabId") long collabId){
				Collaborator collaborator = collaboratorRepository.findById (collabId).get() ;
				
				
				collaborator.setRate(iRatingService.calculMoyRating(collabId));
				
				
			}
		
			//localhost:8089/SpringMVC/collaborator/delete-collaborator/{collaborator-id}
			@DeleteMapping("/delete-collaborator/{collaborator-id}")
			@ResponseBody
			void deleteEvent(@PathVariable("collaborator-id") long id){
				collaboratorService.deleteCollaborator(id);
			}

			
}
