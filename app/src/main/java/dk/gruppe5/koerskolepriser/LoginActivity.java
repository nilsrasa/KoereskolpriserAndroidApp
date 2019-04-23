package dk.gruppe5.koerskolepriser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
            Intent i = new Intent(this, LoggetIndActivity.class);
            startActivity(i);
        }
    }


    private void login(String brugernavn, String password) {
        if (!validering(brugernavn, password)) {

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
}
