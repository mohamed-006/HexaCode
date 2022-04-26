package tn.esprit.HexaCodeProject.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private double note;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Europe/Zagreb")
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Europe/Zagreb")
	private Date end_date;

	private String creator;
	private String Departement;
	private String location;
	
	private int particpants_number;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	private String image;
	
	
	@OneToMany(mappedBy="event")
	@JsonIgnore
	private Set<EventComment> eventcomments;

	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users; 
	
	@JsonIgnore
	@OneToMany
	private Set<Bookmarks>bookmarks;
	
	@JsonIgnore
	@OneToMany(mappedBy="events")
	private Set<Participant>Participants;
	
	
	
	
	

}
