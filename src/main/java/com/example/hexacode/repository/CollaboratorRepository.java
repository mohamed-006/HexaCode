package tn.esprit.hexacode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.hexacode.Entity.Collaborator;
import tn.esprit.hexacode.Entity.Rating;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator , Long>{
	@Query("select c from Collaborator c where c.id = 1")
	public Collaborator findfirstCollaborator();
}
