package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}