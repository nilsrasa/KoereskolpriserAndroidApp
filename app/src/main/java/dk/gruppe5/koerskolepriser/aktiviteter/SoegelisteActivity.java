package dk.gruppe5.koerskolepriser.aktiviteter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Soegning;

public class SoegelisteActivity extends AppCompatActivity {
    private Soegning søgning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soegeliste);

        if (getIntent() != null && getIntent().hasExtra("søgning"))
            søgning = getIntent().getParcelableExtra("søgning");

    }
}
