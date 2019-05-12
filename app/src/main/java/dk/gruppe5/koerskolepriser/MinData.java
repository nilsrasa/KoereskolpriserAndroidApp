package dk.gruppe5.koerskolepriser;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;

public class MinData {
    private static final MinData INSTANCE = new MinData();
    private String brugernavn, password;
    private List<Tilbud> tilbuds;

    private MinData(){
        tilbuds = new ArrayList<>();
    }

    public static MinData getInstance(){
        if (INSTANCE.tilbuds == null) INSTANCE.tilbuds = new ArrayList<>();
        return INSTANCE;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tilbud> getAlleTilbud() {
        return tilbuds;
    }

    public void setTilbuds(Tilbud[] tilbuds) {
        for (Tilbud tilbud: tilbuds) {
            if (!this.tilbuds.contains(tilbud))
                this.tilbuds.add(tilbud);
        }
    }

    public void ryd(){
        brugernavn = null;
        password = null;
        tilbuds = null;
    }
}
