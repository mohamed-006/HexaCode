package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import tn.esprit.HexaCodeProject.Entity.Bookmarks;
import tn.esprit.HexaCodeProject.Entity.Event;

public interface IbookmarkService {
	
	 void addBookmark(Bookmarks b,Long idEvent,Long idUser );
	 
	 void deleteBookmark(Long id);
	 
	 List<Event> GetAllBookmarks(Long id);

}
