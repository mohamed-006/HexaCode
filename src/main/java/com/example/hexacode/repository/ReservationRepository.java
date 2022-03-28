package tn.esprit.hexacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long>{
}
