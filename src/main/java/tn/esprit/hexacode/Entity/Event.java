package tn.esprit.hexacode.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event  implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int note;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String creator;
	private String Departement;
	private String location;
	private int nbPartipants ;
	@ManyToMany(mappedBy="events", cascade = CascadeType.ALL)
	private Set<User> users;

	@OneToMany(mappedBy = "event")
	private Set<EventComment> eventComment;
	
	@ManyToOne 
	private Collaborator collaborator ;
	

	@OneToMany(mappedBy = "event")
	private Set<Reservation> reservation ;


	public Event( String location) {
		super();
	
		this.location = location;
	}
	
	
}
