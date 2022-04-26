package tn.esprit.HexaCodeProject.Entity;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class User  implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date Dob;
	private String PhotoProfil;
	private String Headline;
	private String current_position;
	private String education;
	private String location;
	private String contact_info;
	private String experience;
	private Long points ; 
	@Enumerated(EnumType.STRING)
	private Role Role;
	@JsonIgnore
	@ManyToOne
	private Badge badge ; 
	@JsonIgnore
	@ManyToOne
	private Department department ; 
	@JsonIgnore
	@ManyToMany
	private Set<Interest> activity ;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events ; 
	@JsonIgnore
	@OneToMany
	private Set<Subject> subject;
	@JsonIgnore
	@OneToMany
	private Set<Article> articles;
	@JsonIgnore
	@ManyToMany
	private Set<Messages> messages;
	@JsonIgnore
	@OneToMany
	private Set<Quizz> quizzes;
	
	
	@JsonIgnore
	@OneToMany
	private Set<Bookmarks>bookmarks;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="users")
	private Set<Participant>Participants;
	
	@JsonIgnore
	@OneToMany
	private Set<Follows>Follows;



	

}
