package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TilbudTilBruger implements Parcelable {
    @Expose
    @SerializedName("tilbud")
    private Tilbud tilbud;
    @Expose
    @SerializedName("koreskole")
    private Koereskole køreskole;

    public TilbudTilBruger(){}

    protected TilbudTilBruger(Parcel in) {
        tilbud = in.readParcelable(Tilbud.class.getClassLoader());
        køreskole = in.readParcelable(Koereskole.class.getClassLoader());
    }

    public static final Creator<TilbudTilBruger> CREATOR = new Creator<TilbudTilBruger>() {
        @Override
        public TilbudTilBruger createFromParcel(Parcel in) {
            return new TilbudTilBruger(in);
        }

        @Override
        public TilbudTilBruger[] newArray(int size) {
            return new TilbudTilBruger[size];
        }
    };

    public Tilbud getTilbud() {
        return tilbud;
    }

    public void setTilbud(Tilbud tilbud) {
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

        return "<b><u>Tilbud: </u></b>"
                + tilbud.toString()
                + "<br><br><b><u>Køreskole: </u></b>"
                + "<br>" + "Køreskolenavn: " +  køreskole.getNavn()
                + "<br>" + "Køreskole adresse: " + køreskole.getAdresse()
                + "<br>" + "Postnr: " +  køreskole.getPostnummer()
                + "<br>" + "Telefon: " + køreskole.getTelefonnummer()
                + "<br>" + "E-mail: " + køreskole.getEmail();
    }


    public String lynKursusChecker() {
        String lynKursus = "Ja";
        String notLynKursus = "Nej";
        if (tilbud.getLynkursus() == 0)
            return notLynKursus;
        return lynKursus;
    }


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(tilbud, 0);
        dest.writeParcelable(køreskole, 0);
    }
}
