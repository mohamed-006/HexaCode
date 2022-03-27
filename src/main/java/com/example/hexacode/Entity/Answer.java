package tn.esprit.hexacode.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Answer implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idanswer;

    private String answerorder;

    private String answertext;



    @ManyToOne
    @JsonIgnore
    private Question question;



    public Answer(String answerorder) {
        super();
        this.answerorder = answerorder;
    }



    public Answer(String answerorder,
                  String answertext) {
        super();
        this.answerorder = answerorder;
        this.answertext = answertext;
    }



    public Answer(String answerorder,
                  String answertext,
                  Question question) {
        super();
        this.answerorder = answerorder;
        this.answertext = answertext;
        this.question = question;
    }
















}
