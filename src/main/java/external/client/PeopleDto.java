package external.client;

import external.entity.People;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PeopleDto {

    private String message;
    private int number;
    private People[] people;
}
