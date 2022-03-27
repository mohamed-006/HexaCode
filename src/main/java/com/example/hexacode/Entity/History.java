package tn.esprit.hexacode.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity @Getter @Setter @Data
@AllArgsConstructor @NoArgsConstructor
public class History implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String themeName;
    private String levelName;
    private Long total;
    private Long score;
}
