package com.example.hexacode.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article_Comment implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String text;
    private String author;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean clic_comment ;
    @ManyToOne
    private Article article;

    @ManyToOne
    User user;
}
