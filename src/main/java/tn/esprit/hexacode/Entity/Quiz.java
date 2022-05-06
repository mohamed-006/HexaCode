package tn.esprit.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Quiz implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quiz;
    private String response1;
    private String response2;
    private String response3;
    private String CorrectAnswer;

    @ManyToOne
    @JsonIgnore
    private Level level;

    @OneToMany
    @JsonIgnore
    private Set<Question> question;

    @ManyToOne
    @JsonIgnore
    private User user ;

}
