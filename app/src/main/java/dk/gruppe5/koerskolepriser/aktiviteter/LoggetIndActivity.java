package dk.gruppe5.koerskolepriser.aktiviteter;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.transition.AutoTransition;
import android.view.MenuItem;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.fragmenter.OpretTilbudFragment;
import dk.gruppe5.koerskolepriser.fragmenter.ProfilFragment;
import dk.gruppe5.koerskolepriser.fragmenter.dummy.DummyContent;
import dk.gruppe5.koerskolepriser.fragmenter.mineTilbudFragment;


public class LoggetIndActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
                                                mineTilbudFragment.OnListFragmentInteractionListener{

    private static final String TAG = "LoggetIndSide";

    TextView titel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logget_ind);

        BottomNavigationView navigation = findViewById(R.id.navigation_bar);
        navigation.setOnNavigationItemSelectedListener(this);

        titel = findViewById(R.id.navigation_title_txt);

        indlæsFragment(new mineTilbudFragment());
        titel.setText("MINE TILBUD");



    }

    private boolean indlæsFragment(Fragment fragment) {
        if (fragment != null) {
            fragment.setEnterTransition(new AutoTransition().setDuration(100));

            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment_container, fragment).commit();

            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }

        switch (menuItem.getItemId()) {
            case R.id.navigation_mineTilbud:
                fragment = new mineTilbudFragment();
                titel.setText("MINE TILBUD");
                break;
            case R.id.navigation_OpretTilbud:
                fragment = new OpretTilbudFragment();
                titel.setText("OPRET TILBUD");
                break;
            case R.id.loggetIndProfil:
                fragment = new ProfilFragment();
                titel.setText("MIN PROFIL");
                break;
        }

        return indlæsFragment(fragment);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

}
