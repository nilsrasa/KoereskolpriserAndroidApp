package dk.gruppe5.koerskolepriser.objekter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PakkeTest {
    @Expose
    @SerializedName("tilbud")
    private TilbudTilBruger tilbud;
    @Expose
    @SerializedName("koreskole")
    private Koereskole køreskole;

    public TilbudTilBruger getTilbud() {
        return tilbud;
    }

    public void setTilbud(TilbudTilBruger tilbud) {
        this.tilbud = tilbud;
    }

    public Koereskole getKøreskole() {
        return køreskole;
    }

    public void setKøreskole(Koereskole køreskole) {
        this.køreskole = køreskole;
    }

    @Override
    public String toString() {
        return "PakkeTest{" +
                "tilbud=" + tilbud.toString() +
                ", køreskole=" + køreskole.toString() +
                '}';
    }
}
