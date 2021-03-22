package external.client;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AstronautTable {
    private String message;
    private int number;
    private People[] people;
}



