package com.example.hexacode.Entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

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

import static javax.persistence.FetchType.EAGER;

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
	private String lastname;
	private String username ;
	private String password ;

	@Temporal(TemporalType.DATE)
	private Date Dob;
	private String PhotoProfile;
	private String Headline;
	private String current_position;
	private String education;
	private String location;
	private String contact_info;
	private String experience;
	private int points=0 ;
	@ManyToMany(fetch = EAGER)
	private Collection<Role> roles = new ArrayList<>();
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



}
