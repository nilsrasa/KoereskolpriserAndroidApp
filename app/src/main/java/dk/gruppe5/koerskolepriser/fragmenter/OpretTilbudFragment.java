package dk.gruppe5.koerskolepriser.fragmenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Soegning;

public class OpretTilbudFragment extends Fragment {

    private TextView txt_filtre;
    private EditText etxt_post;
    private View layout_extra;
    private CheckBox cbox_mand, cbox_kvinde, cbox_lyn;
    private Soegning søgning;
    private Spinner sp_pris, sp_type, sp_mærke, sp_størrelse, sp_dag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opret_tilbud, container, false);
    }


}
