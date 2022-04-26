package tn.esprit.HexaCodeProject.Entity;

import java.util.Date;


import javax.persistence.*;

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
public class EventComment {
	
	private static final long serialVersionUID = 1L;
    
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private String autor;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Event event;
	

}
