package tn.esprit.HexaCodeProject.Entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department   implements Serializable{

	private static final long serialVersionUID = 1L;
    
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nom;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy="department")
		private Set<User> users;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy="department1")
		private Set<Collaborator> collaborator;


}
