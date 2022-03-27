package tn.esprit.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity @Getter @Setter @Data
@AllArgsConstructor @NoArgsConstructor
public class Level implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String difficulty;
    @OneToMany(mappedBy = "level", cascade  = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizz_question;
    @ManyToOne
    @JsonIgnore
    private Theme theme;

    public void addQuestion(Quiz quizzQuestion) {
        if(getQuizz_question()==null){
            this.quizz_question = new HashSet<>();
        }
        getQuizz_question().add(quizzQuestion);
        quizzQuestion.setLevel(this);
    }
}
