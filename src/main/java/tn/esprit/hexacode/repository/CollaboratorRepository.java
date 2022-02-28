package tn.esprit.hexacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.hexacode.Entity.Collaborator;
@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator , Long>{

}
