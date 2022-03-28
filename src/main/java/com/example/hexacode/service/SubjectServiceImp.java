package tn.esprit.hexacode.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Subject;
import tn.esprit.hexacode.repo.SubjectRepository;






@Service
public class SubjectServiceImp implements ISubjectService {
	@Autowired
	SubjectRepository subjectRepository ;

	@Override
	public List<Subject> retrieveAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject addSubject(Subject s) {
		s.setDate(LocalDateTime.now());
		return subjectRepository.save(s);
	}

	@Override
	public void deleteSubjectById(Long id) {
		subjectRepository.deleteById(id);
		
	}

	@Override
	public void deleteSubject(Subject s) {
		subjectRepository.delete(s);
	}

	@Override
	public Subject updateSubject(Subject s) {
		return subjectRepository.save(s);
	}

	@Override
	public Subject retrieveSubjectById(Long id) {
		return subjectRepository.findById(id).get();
	}

}
