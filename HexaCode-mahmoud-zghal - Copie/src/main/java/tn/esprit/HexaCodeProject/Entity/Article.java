package tn.esprit.HexaCodeProject.Entity;
import java.io.Serializable;
import java.util.Set;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data

public class Article  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	private String subject ;
	private String title ;
	private String subtitle ;
	private String content ;
	
	
	@Temporal(TemporalType.DATE)
	private Date date ;
	private String author ;
	
	@ManyToOne
	private Subject forum1 ;

	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "article")
	private Set<Article_Comment> article_commentSet;

	
}
