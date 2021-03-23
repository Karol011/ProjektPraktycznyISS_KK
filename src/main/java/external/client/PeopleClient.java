package external.client;

import com.google.gson.Gson;
import lombok.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PeopleClient {

    private OkHttpClient okHttpClient = new OkHttpClient();

    public PeopleDto getAstronautsForADate() {
        PeopleDto peopleDto;
        Request request = new Request.Builder()
                .url("http://api.open-notify.org/astros.json")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                peopleDto = new Gson().fromJson(json, PeopleDto.class);
                return PeopleDto.builder()
                        .message(peopleDto.getMessage())
                        .number(peopleDto.getNumber())
                        .people(peopleDto.getPeople())
                        .build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
