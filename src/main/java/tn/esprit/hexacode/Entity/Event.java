package tn.esprit.hexacode.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Getter @Setter @Data
@AllArgsConstructor @NoArgsConstructor
public class Event {

    private static final Long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long eventid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String location;
    @Column
    private Date time;
    @Column
    private Long totalseats;
    @Column
    private Long regseats;
}

