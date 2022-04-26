package tn.esprit.HexaCodeProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.Event;
@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {
	
	@Query("select e.title , e.start_date from Event e")
	List getCalendar();
	
	

}
