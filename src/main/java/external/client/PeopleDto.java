package external.client;

import external.entity.People;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PeopleDto {

    private String message;
    private int number;
    private People[] people;


}