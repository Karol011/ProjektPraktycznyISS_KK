package external.dto;

import external.entity.People;
import external.entity.StationPosition;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StationPositionDto {

    private StationPosition iss_position;


}
