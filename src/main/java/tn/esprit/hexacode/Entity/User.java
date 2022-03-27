package tn.esprit.hexacode.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 */
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name = "email", nullable=false)
    private String email;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date Dob;
    private String PhotoProfil;
    private String Headline;
    private String current_position;
    private String education;
    private String location;
    private String contact_info;
    private String experience;
    private Long points ;

    @OneToMany
    private Set<Quiz> question;


}
