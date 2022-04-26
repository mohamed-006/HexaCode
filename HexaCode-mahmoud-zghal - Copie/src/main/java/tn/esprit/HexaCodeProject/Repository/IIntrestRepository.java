package tn.esprit.HexaCodeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.Interest;
@Repository
public interface IIntrestRepository extends JpaRepository<Interest, Long>{
	

}
