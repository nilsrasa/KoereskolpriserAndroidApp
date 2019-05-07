package dk.gruppe5.koerskolepriser;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.Koereskole;
import dk.gruppe5.koerskolepriser.objekter.PakkeTest;
import dk.gruppe5.koerskolepriser.objekter.Soegning;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestHandler {

    private static final String URL = "http://10.0.2.2:8080/koereskole_REST/webresources/generic/",
    ALLE_TILBUD = "getAlleTilbud",
    OPRET_TILBUD = "opretTilbud";

    public static PakkeTest[] getAlleTilbud(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL + ALLE_TILBUD)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            return new Gson().fromJson(response.body().string(), PakkeTest[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static PakkeTest[] getTilbudSomMatcher(Soegning søgning){
        List<PakkeTest> matchs = new ArrayList<>();
        PakkeTest[] pakker = getAlleTilbud();

        if (pakker != null){
            for (PakkeTest pakke:pakker){
                if (søgning.matcher(pakke))
                    matchs.add(pakke);
            }
        }


        return matchs.toArray(new PakkeTest[0]);
    }

    public static PakkeTest[] opretTilbud() {
        OkHttpClient client = new OkHttpClient();



        return null;
    }

}
