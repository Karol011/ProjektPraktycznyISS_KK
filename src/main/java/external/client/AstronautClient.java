package external.client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import external.entity.Astronaut;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class AstronautClient {

    private OkHttpClient okHttpClient;

    public Astronaut getAstronautsForADate(LocalDateTime time) {
        Request request = new Request.Builder()
                .url("http://api.open-notify.org/astros.json")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                return new Gson().fromJson(json, Astronaut.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJsonElement() {
        Gson gson = new Gson();

        Request request = new Request.Builder()
                .url("http://api.open-notify.org/astros.json")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();

                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                String keyElement = getJsonElement(jsonObject, "number");

                return new Gson().fromJson(json, Astronaut.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}