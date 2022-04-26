package tn.esprit.HexaCodeProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.Bookmarks;
import tn.esprit.HexaCodeProject.Entity.Event;

@Repository
public interface IBookmarkRepository extends JpaRepository<Bookmarks, Long>{
	
	@Query("select b.eventbookmarked from Bookmarks b where b.userbookmarked.id=:id ")
	List<Event> getBookmarksByUser(@Param("id") Long id);

}
