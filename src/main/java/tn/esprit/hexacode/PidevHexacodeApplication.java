package tn.esprit.hexacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.hexacode.Entity.Collaborator;
import tn.esprit.hexacode.Entity.Event;
import tn.esprit.hexacode.repository.CollaboratorRepository;

@SpringBootApplication
public class PidevHexacodeApplication {
	
	@Autowired
	CollaboratorRepository  collaboratorRepository ;

	public static void main(String[] args) {
		SpringApplication.run(PidevHexacodeApplication.class, args);
		Event event = new Event("aa") ;
		//String loc= event.getLocation();
		System.out.println(event.getLocation());
		
		
	}
}

