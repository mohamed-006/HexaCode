package tn.esprit.hexacode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity @Getter @Setter @Data
@AllArgsConstructor @NoArgsConstructor
public class Theme implements Serializable {

    public static final Long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy  =  "theme",cascade  = CascadeType.ALL)
    private Set<Level> level;
    public void addLevel(Level  level) {
        if(getLevel()==null) {
            this.level = new HashSet<>();
        }
        getLevel().add( level);
        level.setTheme(this);
    }
}
