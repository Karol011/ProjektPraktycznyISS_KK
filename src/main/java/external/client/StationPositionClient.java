package external.client;

import com.google.gson.Gson;
import external.dto.StationPositionDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;

public class StationPositionClient {

    public static final String ISS_LOCATION_URL = "http://api.open-notify.org/iss-now.json";
    private OkHttpClient okHttpClient = new OkHttpClient();

    public StationPositionDto getCurrentPosition() {
        StationPositionDto stationPositionDto;
        Request request = new Request.Builder()
                .url(ISS_LOCATION_URL)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                stationPositionDto = new Gson().fromJson(json, StationPositionDto.class);
                stationPositionDto = StationPositionDto.builder()
                        .iss_position(stationPositionDto.getIss_position())
                        .build();
                stationPositionDto.getIss_position().setTime(LocalDateTime.now());
                return stationPositionDto;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
