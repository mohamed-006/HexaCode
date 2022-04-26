package tn.esprit.HexaCodeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.Participant;
@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Long> {
	
}
