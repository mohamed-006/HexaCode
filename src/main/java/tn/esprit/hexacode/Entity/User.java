package tn.esprit.hexacode.Entity;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	@Enumerated
	private Role Role;
	@ManyToOne
	private Badge badge ; 
	@ManyToOne
	private Department department ; 
	
	@ManyToMany
	private Set<Interest> activity ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events ; 

	@OneToMany
	private Set<Subject> subject;

	@OneToMany
	private Set<Article> articles;

	@ManyToMany
	private Set<Messages> messages;

	@OneToMany
	private Set<Quizz> quizzes;


	@OneToMany(mappedBy = "user2")
	private Set<Reservation> reservation ;
	
	@OneToMany(mappedBy = "user")
	private Set<Rating> rating;
	

	

}
