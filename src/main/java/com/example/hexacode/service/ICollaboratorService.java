package tn.esprit.hexacode.service;

import java.util.List;

import tn.esprit.hexacode.Entity.Collaborator;

public interface ICollaboratorService {
	List<tn.esprit.hexacode.Entity.Collaborator> RetrieveAllCollaborator();
	Collaborator addCollaborator (Collaborator c); 
	Collaborator retrieveCollaborator (Long id );
	Collaborator modifyCollaborator (Collaborator c) ;
	 void deleteCollaborator (Long id) ;


}
