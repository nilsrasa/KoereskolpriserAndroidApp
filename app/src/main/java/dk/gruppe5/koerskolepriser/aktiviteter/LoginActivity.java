package dk.gruppe5.koerskolepriser.aktiviteter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dk.gruppe5.koerskolepriser.DataFetcher;
import dk.gruppe5.koerskolepriser.MinData;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.listeners.OnDataSentListener;
import dk.gruppe5.koerskolepriser.listeners.OnKoereskoleTilbudListener;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnDataSentListener, OnKoereskoleTilbudListener {

    private EditText brugernavn, password;
    private Button loginKnap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        brugernavn = findViewById(R.id.etBrugernavn);
        password = findViewById(R.id.etPassword);

        loginKnap = findViewById(R.id.buttonLogin);
        loginKnap.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == loginKnap) {
            login(brugernavn.getText().toString(), password.getText().toString());
        }
    }


    private void login(String brugernavn, String password) {
        if (validering(brugernavn, password)) {
            DataFetcher.getInstance().login(brugernavn, password, this);
        }
    }


    private boolean validering(String brugernav, String password) {

        boolean valid = true;

        if (TextUtils.isEmpty(brugernav) && TextUtils.isEmpty(password)) {
            this.brugernavn.setError("Indtast et brugernavn");
            this.password.setError("Indtast password");
            valid = false;
        } else if (TextUtils.isEmpty(brugernav) && !TextUtils.isEmpty(password)) {
            this.password.setError("Indtast password");
            valid = false;
        } else if (!TextUtils.isEmpty(brugernav) && TextUtils.isEmpty(password)) {
            this.brugernavn.setError("Indtast et brugernavn");
            valid = false;
        }
        return valid;
    }

    @Override
    public void onSuccess(String[] strings) {
        MinData.getInstance().setBrugernavn(brugernavn.getText().toString());
        MinData.getInstance().setPassword(password.getText().toString());

        DataFetcher.getInstance().hentKøreskoleTilbud(brugernavn.getText().toString(),
                password.getText().toString(), this);
    }

    @Override
    public void onSuccess(Tilbud[] tilbuds) {
        MinData.getInstance().setTilbuds(tilbuds);

        Intent i = new Intent(this, LoggetIndActivity.class);
        startActivity(i);
    }

    @Override
    public void onError(Throwable e) {
        Log.e("LoginSIDE", e.toString());
        Toast.makeText(this, "Fejl ved login ", Toast.LENGTH_SHORT).show();
    }
}
