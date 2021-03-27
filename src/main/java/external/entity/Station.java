package external.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station")
@ToString
public class Station {

    @Column(name = "station_id")
    @Id
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "station")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<StationPosition> positions = new HashSet<>();
    @OneToMany(mappedBy = "station")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<People> people = new HashSet<>();
    @OneToMany(mappedBy = "station")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<People> speeds = new HashSet<>();


}
