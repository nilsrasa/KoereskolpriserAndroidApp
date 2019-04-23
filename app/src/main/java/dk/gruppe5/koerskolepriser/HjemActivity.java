package dk.gruppe5.koerskolepriser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class HjemActivity extends AppCompatActivity implements View.OnClickListener {
    //private Button btn_søg, btn_login;
    //private TextView txt_filtre;
    //private Spinner sp_pris, sp_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hjem);

        //Buttons
        Button btn_søg, btn_login;
        btn_login = findViewById(R.id.btn_hjem_login);
        btn_søg = findViewById(R.id.btn_hjem_soeg);

        btn_login.setOnClickListener(this);
        btn_søg.setOnClickListener(this);

        //Text
        TextView txt_filtre = findViewById(R.id.txt_hjem_filtre);
        txt_filtre.setOnClickListener(this);

        //Spinners
        Spinner sp_pris, sp_type;
        sp_type = findViewById(R.id.sp_hjem_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.kørekort_typer, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);

        sp_pris = findViewById(R.id.sp_hjem_pris);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hjem_login){
            //TODO: skift til login aktiviteten
        }
        else if (view.getId() == R.id.btn_hjem_soeg){
            //TODO: start søgning og skift aktivitet
        }
        else if (view.getId() == R.id.txt_hjem_filtre){
            //TODO: vis de resterende filtre
        }
    }
}
