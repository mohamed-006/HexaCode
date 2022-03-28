package com.example.hexacode.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
	@JsonIgnore
	private Subject forum1 ;

	@ManyToOne
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "article")
	private Set<Article_Comment> article_commentSet;

	@ManyToOne
	private Department department2 ;

}
