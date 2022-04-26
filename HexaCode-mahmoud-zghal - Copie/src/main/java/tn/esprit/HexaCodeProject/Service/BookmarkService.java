package tn.esprit.HexaCodeProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.HexaCodeProject.Entity.Bookmarks;
import tn.esprit.HexaCodeProject.Entity.Event;
import tn.esprit.HexaCodeProject.Entity.User;
import tn.esprit.HexaCodeProject.Repository.IBookmarkRepository;
import tn.esprit.HexaCodeProject.Repository.IEventRepository;
import tn.esprit.HexaCodeProject.Repository.IUserRepository;

@Service
public class BookmarkService implements IbookmarkService {
	
	@Autowired
	IBookmarkRepository bookmarkRepo;
	
	@Autowired
	IEventRepository eventrepo;
	@Autowired
	IUserRepository userRepo;
	
	public void addBookmark(Bookmarks b,Long idEvent,Long idUser ){
		Event ev= eventrepo.findById(idEvent).orElse(null);
		User user=userRepo.findById(idUser).orElse(null);
		b.setEventbookmarked(ev);
		b.setUserbookmarked(user);
		bookmarkRepo.save(b);
	}
	
	public void deleteBookmark(Long id){
		bookmarkRepo.deleteById(id);
	}
	
	
	public List<Event> GetAllBookmarks(Long id) {
		
		List<Event> boookmarks =  bookmarkRepo.getBookmarksByUser(id);
		return boookmarks;
	}

	

	

	
	

}
