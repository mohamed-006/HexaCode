package tn.esprit.hexacode.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.hexacode.Entity.Subject;

import tn.esprit.hexacode.service.ISubjectService;

@RestController
@RequestMapping(value = "subject")
public class SubjectController {
	@Autowired
	private ISubjectService iSubjectService;

	
//	localhost:8080/subject/add-subject
	@PostMapping(value = "/add-subject")
	public Subject addSubject(@RequestBody Subject s) {
		return iSubjectService.addSubject(s);
	}
	
	

	@DeleteMapping(value = "/delete-subject/{id}")
	void deleteSubjectById(@PathVariable Long id) {
		Subject subject = iSubjectService.retrieveSubjectById(id);
		if(LocalDateTime.now().minusSeconds(24L).isBefore(subject.getDate()))
		 iSubjectService.deleteSubjectById(id);
	}
	
	@DeleteMapping(value = "/delete-subject")
	void deleteSubject(@RequestBody Subject s) {
		 iSubjectService.deleteSubject(s);
	}
	
	 @GetMapping(value ="/showall")
	 public List<Subject> retrieveAllSubject() {
	    return iSubjectService.retrieveAllSubject();
	  }
	 
	 @GetMapping(value ="/showsub/{id}")
	 public Subject retriveSubject(@PathVariable Long id) {
	    return iSubjectService.retrieveSubjectById(id);
	  }
	 
	 @GetMapping(value ="/showusersub/{id}")
	 public String retriveUserSubject(@PathVariable Long id) {
	    return iSubjectService.retrieveSubjectById(id).getUser().getName();
	  }
	 
	 @PutMapping(value = "/update-subject")
		public Subject updaRayon(@RequestBody Subject s) {
		 Subject subject = iSubjectService.retrieveSubjectById(s.getId());
			if(LocalDateTime.now().minusSeconds(24L).isBefore(subject.getDate()))
			return iSubjectService.updateSubject(s);
			return null;
		}
	 
	
		

}
