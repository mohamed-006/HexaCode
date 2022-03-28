package tn.esprit.hexacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.hexacode.Entity.Offers;
@Repository
public interface OfferRepository extends JpaRepository<Offers , Long>{

}
