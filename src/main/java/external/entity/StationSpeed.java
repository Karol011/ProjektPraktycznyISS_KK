package external.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "station_speed")
@Table
public class StationSpeed {

    @Column(name = "station_speed_id")
    @Id
    int id;
    @Column
    double speed;
    @ManyToOne
    private Station station;
}
