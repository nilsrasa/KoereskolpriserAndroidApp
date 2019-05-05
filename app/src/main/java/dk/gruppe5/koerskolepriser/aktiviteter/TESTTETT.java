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

    String url = "http://10.0.2.2:8080/koereskole_REST/webresources/generic/getAlleTilbud";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtett);

        textViewResult = findViewById(R.id.textView_Result);




    }


}
