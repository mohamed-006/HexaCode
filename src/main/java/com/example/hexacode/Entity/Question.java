package tn.esprit.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Question implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQuestion;

    private Long questionorder;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String questiontext;


    private Boolean isvalid = false;

    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String answer;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id_quiz")
    private Quiz quiz;
//
//
//    public Question(Integer questionorder,
//                    String questiontext) {
//        super();
//        this.questionorder = questionorder;
//        this.questiontext = questiontext;
//    }
//
//
//    public Question(Integer questionorder,
//                    String questiontext,
//                    Boolean isvalid) {
//        super();
//        this.questionorder = questionorder;
//        this.questiontext = questiontext;
//        this.isvalid = isvalid;
//    }

}
