package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Collaborator;

import tn.esprit.hexacode.repository.CollaboratorRepository;

@Service
public class CollaboratorServiceImp implements ICollaboratorService  {
	
	@Autowired
	CollaboratorRepository collaboratorRepository ;

	

	@Override
	public Collaborator addCollaborator(Collaborator c) {
		
		return collaboratorRepository.save(c);
	}

	@Override
	public Collaborator retrieveCollaborator(Long id) {
		Collaborator collaborator = collaboratorRepository.findById(id).orElse(null);
		return collaborator;
	}

	@Override
	public Collaborator modifyCollaborator(Collaborator c) {
		
		return collaboratorRepository.save(c);
	}

	@Override
	public void deleteCollaborator(Long id) {
		collaboratorRepository.deleteById(id);
		
	}

	@Override
	public List<Collaborator> RetrieveAllCollaborator() {
		List<Collaborator> collaborator =collaboratorRepository.findAll();
		return collaborator;
	}

}
