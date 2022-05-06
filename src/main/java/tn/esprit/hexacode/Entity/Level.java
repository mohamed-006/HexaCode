package tn.esprit.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Question> questions;
    @ManyToOne
    @JsonIgnore
    private Theme theme;

    public void addQuestion(Question question) {
        if(getQuestions()==null){
            this.questions = new ArrayList<>();
        }
        getQuestions().add(question);
        question.setLevel(this);
    }
}
