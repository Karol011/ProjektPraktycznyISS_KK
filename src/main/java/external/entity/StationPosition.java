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
@Entity
@Table(name = "station_position")
public class StationPosition {

    @Column(name = "station_position_id")
    @Id
    private int id;
    @Column
    private LocalDateTime time;
    @Column
    private double longtitude;
    @Column
    private double latitude;
    @ManyToOne
    private Station station;
}
