package dk.gruppe5.koerskolepriser;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;
import dk.gruppe5.koerskolepriser.objekter.Soegning;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class RestHandler {

    private static final String URL = "http://10.0.2.2:8080/koereskole_REST/webresources/generic/",
    ALLE_TILBUD = "getAlleTilbud",
    OPRET_TILBUD = "opretTilbud";

    public static PakkeTilbud[] getAlleTilbud(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL + ALLE_TILBUD)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            return new Gson().fromJson(response.body().string(), PakkeTilbud[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static PakkeTilbud[] getTilbudSomMatcher(Soegning søgning){
        List<PakkeTilbud> matchs = new ArrayList<>();
        PakkeTilbud[] pakker = getAlleTilbud();

        if (pakker != null){
            for (PakkeTilbud pakke:pakker){
                if (søgning.matcher(pakke))
                    matchs.add(pakke);
            }
        }


        return matchs.toArray(new PakkeTilbud[0]);
    }

    public static PakkeTilbud[] opretTilbud() {
        OkHttpClient client = new OkHttpClient();



        return null;
    }

}
