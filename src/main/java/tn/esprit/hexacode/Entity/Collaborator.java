package tn.esprit.hexacode.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Collaborator implements Serializable {
private static final long serialVersionUID = 1L;
    
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String offre;
    private int rate;
    private String duree ;
 
    @ManyToOne
    @JsonIgnore
	private Department department1 ; 
	
    @JsonIgnore
@OneToMany(mappedBy="collaborator")
private Set<Event> event ;

    @JsonIgnore
@OneToMany(mappedBy="collaborators")
private Set<Offers> offers ;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="collaborator")
    private Set<Rating> ratings ;

	public Collaborator( int rate) {
		super();

		this.rate = rate;
	}
    
    
}





