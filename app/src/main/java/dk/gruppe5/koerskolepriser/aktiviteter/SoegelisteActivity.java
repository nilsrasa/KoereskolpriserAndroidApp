package dk.gruppe5.koerskolepriser.aktiviteter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.Soegning;

public class SoegelisteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton img_btn_tilbage;

    private Soegning søgning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soegeliste);

        img_btn_tilbage = findViewById(R.id.btn_soegliste_tilbage);
        img_btn_tilbage.setOnClickListener(this);

        if (getIntent() != null && getIntent().hasExtra("søgning"))
            søgning = getIntent().getParcelableExtra("søgning");

    }

    @Override
    public void onClick(View view) {
        if (view == img_btn_tilbage) {
            finish();
        }
    }
}
