package external.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station")
public class Station {

    @Column(name = "station_id")
    @Id
    private int id;
    @Column
    private String name;
    @OneToMany
    @JoinColumn(name = "station_position_id")
    private Set<StationPosition> positions = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "people_id")
    private Set<People> people = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "station_speed_id")
    private Set<People> speeds = new HashSet<>();

}
