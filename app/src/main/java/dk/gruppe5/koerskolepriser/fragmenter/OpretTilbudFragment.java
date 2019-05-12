package dk.gruppe5.koerskolepriser.fragmenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.transition.AutoTransition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.APIKlient;
import dk.gruppe5.koerskolepriser.DataFetcher;
import dk.gruppe5.koerskolepriser.MinData;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.adaptere.PrisAdapter_Opret;
import dk.gruppe5.koerskolepriser.aktiviteter.LoggetIndActivity;
import dk.gruppe5.koerskolepriser.listeners.OnDataSentListener;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import dk.gruppe5.koerskolepriser.objekter.Tilgaengeligedage;
import retrofit2.Retrofit;

public class OpretTilbudFragment extends Fragment implements View.OnClickListener, OnDataSentListener {

    private TextView txt_filtre;
    private EditText beskrivelse;
    private View layout_extra;
    private CheckBox cbox_mand, cbox_kvinde, cbox_lyn;
    private CheckBox man, tir, ons, tor, fre, lør, søn;
    private Button opret_btn;
    private Tilbud tilbud;
    private Spinner sp_pris, sp_type, sp_mærke, sp_størrelse;
    Retrofit retrofit;


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
        beskrivelse = v.findViewById(R.id.etxt_opret_beskrivelse);

        //Spinners
        sp_type = v.findViewById(R.id.sp_opret_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.kørekort_typer_opret, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);

        sp_pris = v.findViewById(R.id.sp_opret_pris);//Pris
        adapter = new PrisAdapter_Opret<CharSequence>(getContext(),
                android.R.layout.simple_spinner_item,
                getContext().getResources().getStringArray(R.array.priser_opret));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pris.setAdapter(adapter);

        sp_mærke = v.findViewById(R.id.sp_opret_maerke);//Mærke
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.mærker_opret, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_mærke.setAdapter(adapter);

        sp_størrelse = v.findViewById(R.id.sp_opret_stoerrelse);//Størrelse
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sørrelse_opret, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_størrelse.setAdapter(adapter);

        //Checboxes
        cbox_mand = v.findViewById(R.id.cbox_opret_mand);
        cbox_kvinde = v.findViewById(R.id.cbox_opret_kvinde);
        cbox_lyn = v.findViewById(R.id.cbox_opret_lyn);
        man = v.findViewById(R.id.cbMan);
        tir = v.findViewById(R.id.cbTirs);
        ons = v.findViewById(R.id.cbOns);
        tor = v.findViewById(R.id.cbTors);
        fre = v.findViewById(R.id.cbFre);
        lør = v.findViewById(R.id.cbLør);
        søn = v.findViewById(R.id.cbSøn);

        //Extra
        layout_extra = v.findViewById(R.id.layout_opret_extra);
        layout_extra.setVisibility(View.GONE);

        //Tilbud instantiering
        tilbud = new Tilbud();

        retrofit = APIKlient.getKlient();

        return v;
    }

    private void dagChecker() {

        int[] arr = new int[7];

        if (man.isChecked())
            arr[0] = 1;
        else arr[0] = 0;
        if (tir.isChecked())
            arr[1] = 1;
        else arr[1] = 0;
        if (ons.isChecked())
            arr[2] = 1;
        else arr[2] = 0;
        if (tor.isChecked())
            arr[3] = 1;
        else arr[3] = 0;
        if (fre.isChecked())
            arr[4] = 1;
        else arr[4] = 0;
        if (lør.isChecked())
            arr[5] = 1;
        else arr[5] = 0;
        if (søn.isChecked())
            arr[6] = 1;
        else arr[6] = 0;


        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

    }

    private void lynChecker() {
        if (cbox_lyn.isChecked()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private String koenChecker() {
        String s;

        if (cbox_mand.isChecked() && cbox_kvinde.isChecked()) {
            return "mand og kvinde";
        } else if (cbox_kvinde.isChecked()) {
            return ("kvinde");
        } else if (cbox_mand.isChecked()) {
            return ("mand");}
            else
                return "andet";
    }

    private void opretTilbud() {} {
        /*Tilbud tilbud = new Tilbud(
                brugernavn
                        + password
                        + brugernavn
                        + sp_pris.getSelectedItem().toString()
                        + sp_type.getSelectedItem().toString()
                        + lynChecker()
                        + koenChecker()
                        + sp_mærke.getSelectedItem().toString()
                        + sp_størrelse.getSelectedItem().toString()
                        + koenChecker()
                        + dagChecker();
                        + id );
        */

        //Call<Tilbud> send = APIService.opretTilbud;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_opretTilbud) {

            tilbud = new Tilbud();
            Tilgaengeligedage tilgaengeligedage = new Tilgaengeligedage();

            tilgaengeligedage.setTilgangelig_mandag(man.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_tirsdag(tir.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_onsdag(ons.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_torsdag(tor.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_fredag(fre.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_lordag(lør.isChecked()?1:0);
            tilgaengeligedage.setTilgangelig_sondag(søn.isChecked()?1:0);

            tilbud.setKørekort_type(sp_type.getSelectedItem().toString());
            tilbud.setPris(Integer.parseInt(sp_pris.getSelectedItem().toString()));
            tilbud.setLynkursus(cbox_lyn.isChecked()?1:0);
            tilbud.setKøn(koenChecker());
            tilbud.setMærke(sp_mærke.getSelectedItem().toString());
            tilbud.setStørrelse(sp_størrelse.getSelectedItem().toString());
            tilbud.setTilgængeligedage(tilgaengeligedage);
            tilbud.setBeskrivelse(beskrivelse.getText().toString());

            DataFetcher.getInstance().opretTilbud(tilbud,
                    MinData.getInstance().getBrugernavn(),
                    MinData.getInstance().getPassword(), this);

        } else if (view.getId() == R.id.txt_opretTilbud_filtre) {
            layout_extra.setVisibility(View.VISIBLE);
            txt_filtre.setVisibility(View.GONE);
        }

    }

    @Override
    public void onSuccess(String[] strings) {
        MinData.getInstance().getAlleTilbud().add(tilbud);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }
}
