package dk.gruppe5.koerskolepriser.fragmenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;

public class OpretTilbudFragment extends Fragment implements View.OnClickListener {

    private TextView txt_filtre;
    private EditText etxt_post;
    private View layout_extra;
    private CheckBox cbox_mand, cbox_kvinde, cbox_lyn;
    private Button opret_btn;
    private Tilbud tilbud;
    private Spinner sp_pris, sp_type, sp_mærke, sp_størrelse, sp_dag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_opret_tilbud, container, false);

        //Buttons
        opret_btn = v.findViewById(R.id.btn_opretTilbud);

        opret_btn.setOnClickListener(this);

        //Text
        txt_filtre = v.findViewById(R.id.txt_opretTilbud_filtre);
        txt_filtre.setOnClickListener(this);
        SpannableString content = new SpannableString(getText(R.string.flere_filtre));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txt_filtre.setText(content);

        //EditText
        etxt_post = v.findViewById(R.id.etxt_opret_post);

        //Spinners
        sp_type = v.findViewById(R.id.sp_opret_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.kørekort_typer, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);

        sp_pris = v.findViewById(R.id.sp_opret_pris);//Pris
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.priser, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pris.setAdapter(adapter);

        sp_mærke = v.findViewById(R.id.sp_opret_maerke);//Mærke
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.mærker, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_mærke.setAdapter(adapter);

        sp_størrelse = v.findViewById(R.id.sp_opret_stoerrelse);//Størrelse
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sørrelse, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_størrelse.setAdapter(adapter);

        sp_dag = v.findViewById(R.id.sp_opret_dage);//Ønskede dage
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.ønskedage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_dag.setAdapter(adapter);

        //Checboxes
        cbox_mand = v.findViewById(R.id.cbox_opret_mand);
        cbox_kvinde = v.findViewById(R.id.cbox_opret_kvinde);
        cbox_lyn = v.findViewById(R.id.cbox_opret_lyn);

        //Extra
        layout_extra = v.findViewById(R.id.layout_opret_extra);
        layout_extra.setVisibility(View.GONE);

        //Tilbud instantiering
        tilbud = new Tilbud();

        return v;
    }


    @Override
    public void onClick(View view) {
   /*     if (view.getId() == R.id.btn_opretTilbud) {
            tilbud.setKørekort_type(sp_type.getSelectedItem().toString());
            tilbud.setPostnummer(etxt_post.getText().toString());
            tilbud.setPris(sp_pris.getSelectedItem().toString());
            if (layout_extra.getVisibility() == View.GONE) {
                //Søg for std filtre
            }
            else {
                tilbud.setLynkursus(cbox_lyn.isChecked());
                tilbud.setMand(cbox_mand.isChecked());
                tilbud.setKvinde(cbox_kvinde.isChecked());
                tilbud.setMærke(sp_mærke.getSelectedItem().toString());
                tilbud.setStørrelse(sp_størrelse.getSelectedItem().toString());
                tilbud.setØnskedage(sp_dag.getSelectedItem().toString());

                //Søg for alle filtre
            }

            //Opretter intent og vidersender tilbud objektet til (database på server)
        }
        else if (view == txt_filtre){
            layout_extra.setVisibility(View.VISIBLE);
            txt_filtre.setVisibility(View.GONE);
        } */
    }
}
