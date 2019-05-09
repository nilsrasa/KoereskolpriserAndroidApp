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

import dk.gruppe5.koerskolepriser.APIKlient;
import dk.gruppe5.koerskolepriser.APIService;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import retrofit2.Call;
import retrofit2.Retrofit;

public class OpretTilbudFragment extends Fragment implements View.OnClickListener {

    private TextView txt_filtre;
    private EditText etxt_post;
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

    private void postNrChecker() {
        if (etxt_post.getText().length() > 4) {
            etxt_post.setError("Et dansk postnummer er på 4 cifre!");
        } else if (etxt_post.getText().length() == 0) {
            etxt_post.setError("Skriv et postnummer");
        } else if (etxt_post.getText().length() == 4) {
            System.out.println(etxt_post.getText().toString());
        }
    }

    private void lynChecker() {
        if (cbox_lyn.isChecked()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private void koenChecker() {
            if (cbox_mand.isChecked() && cbox_kvinde.isChecked()) {
                System.out.println("mand og kvinde");
            } else if (cbox_kvinde.isChecked()) {
                System.out.println("kvinde");
            } else if (cbox_mand.isChecked()) {
                System.out.println("mand");
            } else if (!cbox_mand.isChecked() && !cbox_kvinde.isChecked()) {
                System.out.println("andet");
            }
    }


    final String brugernavn = "s175132";
    final String password = "DS2019";

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

            System.out.println(sp_type.getSelectedItem().toString());
            postNrChecker();
            System.out.println(sp_pris.getSelectedItem().toString());
            lynChecker();
            koenChecker();
            System.out.println(sp_mærke.getSelectedItem().toString());
            System.out.println(sp_størrelse.getSelectedItem().toString());
            dagChecker();
        } else if (view.getId() == R.id.txt_opretTilbud_filtre) {
            layout_extra.setVisibility(View.VISIBLE);
            txt_filtre.setVisibility(View.GONE);
        }

    }
}
