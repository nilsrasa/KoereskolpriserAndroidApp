package dk.gruppe5.koerskolepriser.aktiviteter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.PakkeTest;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TESTTETT extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    private Button testKnap;

    String url = "http://10.0.2.2:8080/koereskole_REST/webresources/generic/getAlleTilbud";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtett);

        textViewResult = findViewById(R.id.textView_Result_koreskole_id);

        testKnap = findViewById(R.id.buttonTest);
        testKnap.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == testKnap) {
            AsyncTask asyncTask = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {

                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(url)
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

                @Override
                protected void onPostExecute(Object o) {
                    PakkeTest[] pakker = (PakkeTest[]) o;
                    TilbudTilBruger tilbud = pakker[0].getTilbud();

                    //TODO: vis et enkelt tilbud
                }

            }.execute();
        }
    }

}
