package tn.esprit.HexaCodeProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.HexaCodeProject.Entity.Interest;
import tn.esprit.HexaCodeProject.Service.IInterestService;

@RestController
@RequestMapping(value = "Intrest")
public class IntrestRestController {
	@Autowired
	IInterestService intrestservice;
	
	@PostMapping (value ="/add_intrest")
	public void addIntrest(@RequestBody Interest in)
	{
		intrestservice.addIntrest(in);
	}
	
	@PutMapping(value="/update_intrest")
	public void updateIntrest(@RequestBody Interest in)
	{
		intrestservice.updateIntrest(in);
	}
	
	
	@RequestMapping(value = "/delete_intrest/{id}", method = RequestMethod.DELETE)
	public void deleteIntrest(@PathVariable long id)
	{
		intrestservice.deleteIntrest(id);
	}
	
	@PostMapping (value ="/add_follow/{idIntrest}/{idUser}")
	public void Follow(@PathVariable("idUser")Long idUser , @PathVariable("idIntrest") Long idIntrest){
		intrestservice.Follow(idUser, idIntrest);
	}
	
	@DeleteMapping (value="/delete_follow/{idFollow}")
	public void deleteFollow(@PathVariable("idFollow")Long id){
		intrestservice.Unfollow(id);
		
	}
	
	@GetMapping("/get_follows_user/{iduser}")
	public List<Interest>gettallfollows(@PathVariable("iduser") Long idUser)
	{
		List<Interest>Follows=intrestservice.GetAllFollows(idUser);
		return Follows;
	}
	
	
	

}
