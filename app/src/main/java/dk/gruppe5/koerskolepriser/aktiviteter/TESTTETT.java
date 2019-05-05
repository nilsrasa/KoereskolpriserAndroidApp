package dk.gruppe5.koerskolepriser.aktiviteter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;

import dk.gruppe5.koerskolepriser.JsonPlaceHolderApiTest;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.TilbudTest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TESTTETT extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtett);

        textViewResult = findViewById(R.id.textView_Result);

        // Instans af retrofit
        // .base Url = "http://bla.blablabla.com/"
        // .converter = Her defineres at der bruges Gson til at parse response
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/koereskole_REST/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Interface til JsonPlaceHolderApi
        //JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        JsonPlaceHolderApiTest jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApiTest.class);


        JsonParser jsonParser = new JsonParser();



        // kald til at execute network request
        //Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        Call<List<TilbudTest>> call = jsonPlaceHolderApi.getAlleTilbud();

        /*call.execute skal helst ikke kaldes i main thread,
        da den køre synkront med main thread/nuværende thread,
        hvilket vil give en exception, fordi det ville fryse appen.
        Brug istedet call.enqueue til at køre i en baggrundstråd
         */

        // execute call i baggrundstråd ved hjælp af retrofit
        //call.enqueue(new Callback<List<Post>>() {
        call.enqueue(new Callback<List<TilbudTest>>() {

            // Hvis request bliver executet
            @Override
            public void onResponse(Call<List<TilbudTest>> call, Response<List<TilbudTest>> response) {

                // Hvis der tilgås en slettet side eller anden HTTP-fejlkode
                if (!response.isSuccessful()) {
                    // udskriv http-fejlkoden
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                // hvis der fås den rigtige response, fås en liste med posts fra Json array
                List<TilbudTest> posts = response.body();

                for (TilbudTest post : posts) {
                    String content ="";
                    content += "KøreskoleID: " + post.getKoreskole_id() + "\n";
                    content += "Pris: " + post.getPris() + "\n";
                    content += "Kørekort: " + post.getKorekort_type()+ "\n";
                    content += "Lynkursus: " + post.getLynkursus()+ "\n";
                    content += "Bilmærke: " + post.getBilmarke()+ "\n";
                    content += "Bilstørrelse: " + post.getBilstorrelse()+ "\n";
                    content += "Køn: " + post.getKon()+ "\n";
                    content += "Beskrivelse: " + post.getBeskrivelse()+ "\n\n";

                    Log.d("tilbudResponse", " :: :: " + posts);

                    textViewResult.append(content);
                }

            }

            // Hvis der er taste fejl eller andre fejl i at sende request
            @Override
            public void onFailure(Call<List<TilbudTest>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });


    }


}
