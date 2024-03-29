package dk.gruppe5.koerskolepriser.aktiviteter;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.adaptere.BrugerTilbudAdapter;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;

public class SoegelisteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton img_btn_tilbage;
    private ListView listView;

    private List<TilbudTilBruger> pakker = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soegeliste);

        img_btn_tilbage = findViewById(R.id.btn_soegliste_tilbage);
        img_btn_tilbage.setOnClickListener(this);

        listView = findViewById(R.id.lv_soegliste_liste);

        Parcelable[] parcelables = null;
        if (getIntent() != null && getIntent().hasExtra("tilbud"))
            parcelables = getIntent().getParcelableArrayExtra("tilbud");

        if (parcelables != null) {
            for (Parcelable parcelable : parcelables) {
                pakker.add((TilbudTilBruger) parcelable);
            }
        }

        BrugerTilbudAdapter adapter = new BrugerTilbudAdapter(this, pakker);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view == img_btn_tilbage) {
            finish();
        }
    }
}
