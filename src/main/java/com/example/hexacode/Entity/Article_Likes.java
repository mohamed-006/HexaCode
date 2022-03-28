package com.example.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Article_Likes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean clic_like ;

    @Enumerated(EnumType.STRING)
    private ReactARTICLE react ;

    @ManyToOne
    @JsonIgnore
    Article articles;

    @ManyToOne
    @JsonIgnore
    User users;
}
