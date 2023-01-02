package tn.esprit.hexacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Personne;
@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long>{


}
