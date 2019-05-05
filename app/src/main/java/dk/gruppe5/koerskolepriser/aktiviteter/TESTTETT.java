package dk.gruppe5.koerskolepriser.aktiviteter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import dk.gruppe5.koerskolepriser.JsonPlaceHolderApiTest;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.TilbudTest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TESTTETT extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    private Button testKnap;

    String url = "http://10.0.2.2:8080/koereskole_REST/webresources/generic/getAlleTilbud";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtett);

        textViewResult = findViewById(R.id.textView_Result);

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
                        return response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                @Override
                protected void onPostExecute(Object o) {
                    textViewResult.setText(o.toString());
                }

            }.execute();
        }
    }

}
