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
    private Long idQuiz;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String name;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String response1;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String response2;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String response3;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String CorrectAnswer;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String response;
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String theme;

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
