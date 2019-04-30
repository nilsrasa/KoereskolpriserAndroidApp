package dk.gruppe5.koerskolepriser.aktiviteter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Soegning;

public class HjemActivity extends AppCompatActivity implements View.OnClickListener {
    //private Button btn_søg, btn_login;
    private TextView txt_filtre;
    private EditText etxt_post;
    private View layout_extra;
    private CheckBox cbox_mand, cbox_kvinde, cbox_lyn;
    private Soegning søgning;
    private Spinner sp_pris, sp_type, sp_mærke, sp_størrelse, sp_dag;

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
        txt_filtre = findViewById(R.id.txt_hjem_filtre);
        txt_filtre.setOnClickListener(this);
        SpannableString content = new SpannableString(getText(R.string.flere_filtre));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txt_filtre.setText(content);

        //EditText
        etxt_post = findViewById(R.id.etxt_hjem_post);

        //Spinners
        sp_type = findViewById(R.id.sp_hjem_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.kørekort_typer, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);

        sp_pris = findViewById(R.id.sp_hjem_pris);//Pris
        adapter = ArrayAdapter.createFromResource(this,
                R.array.priser, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pris.setAdapter(adapter);

        sp_mærke = findViewById(R.id.sp_hjem_maerke);//Mærke
        adapter = ArrayAdapter.createFromResource(this,
                R.array.mærker, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_mærke.setAdapter(adapter);

        sp_størrelse = findViewById(R.id.sp_hjem_stoerrelse);//Størrelse
        adapter = ArrayAdapter.createFromResource(this,
                R.array.sørrelse, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_størrelse.setAdapter(adapter);

        sp_dag = findViewById(R.id.sp_hjem_dage);//Ønskede dage
        adapter = ArrayAdapter.createFromResource(this,
                R.array.ønskedage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_dag.setAdapter(adapter);

        //Checkboxes
        cbox_mand = findViewById(R.id.cbox_hjem_mand);
        cbox_kvinde = findViewById(R.id.cbox_hjem_kvinde);
        cbox_lyn = findViewById(R.id.cbox_hjem_lyn);

        //Extra
        layout_extra = findViewById(R.id.layout_hjem_extra);
        layout_extra.setVisibility(View.GONE);

        //Søgning instantiering
        søgning = new Soegning();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hjem_login){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.btn_hjem_soeg){
            søgning.setKørekort_type(sp_type.getSelectedItem().toString());
            søgning.setPostnummer(etxt_post.getText().toString());
            søgning.setPris(sp_pris.getSelectedItem().toString());
            if (layout_extra.getVisibility() == View.GONE){
                //Søg for std filtre
            }
            else {
                søgning.setAvanceret(true);
                søgning.setLynkursus(cbox_lyn.isChecked());
                søgning.setMand(cbox_mand.isChecked());
                søgning.setKvinde(cbox_kvinde.isChecked());
                søgning.setMærke(sp_mærke.getSelectedItem().toString());
                søgning.setStørrelse(sp_størrelse.getSelectedItem().toString());
                søgning.setØnskedage(sp_dag.getSelectedItem().toString());

                //Søg for alle filtre
            }

            //Opretter intent og vidersender søgning objektet til næste aktivitet
            Intent intent = new Intent(this, SoegelisteActivity.class);
            intent.putExtra("søgning", søgning);
            startActivity(intent);
        }
        else if (view.getId() == R.id.txt_hjem_filtre){
            layout_extra.setVisibility(View.VISIBLE);
            txt_filtre.setVisibility(View.GONE);
        }
    }
}