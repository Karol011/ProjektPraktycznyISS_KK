package external.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "astronaut")
@Table
public class Astronaut {

    @Column(name = "astronaut_id")
    @Id
    private int id;

    @Column
    private LocalDateTime time;
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToOne
    private Station station;


}
