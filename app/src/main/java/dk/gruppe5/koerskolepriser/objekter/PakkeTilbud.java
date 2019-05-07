package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PakkeTilbud implements Parcelable {
    @Expose
    @SerializedName("tilbud")
    private TilbudTilBruger tilbud;
    @Expose
    @SerializedName("koreskole")
    private Koereskole køreskole;

    public PakkeTilbud(){}

    protected PakkeTilbud(Parcel in) {
        tilbud = in.readParcelable(TilbudTilBruger.class.getClassLoader());
        køreskole = in.readParcelable(Koereskole.class.getClassLoader());
    }

    public static final Creator<PakkeTilbud> CREATOR = new Creator<PakkeTilbud>() {
        @Override
        public PakkeTilbud createFromParcel(Parcel in) {
            return new PakkeTilbud(in);
        }

        @Override
        public PakkeTilbud[] newArray(int size) {
            return new PakkeTilbud[size];
        }
    };

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

        return "<b><u>Tilbud: </u></b>"
                + "<br>" + "Kørekort: " + tilbud.getKørekort_type()
                + "<br>" + "Pris: " + tilbud.getPris()
                + "<br>" + "Lynkurs: " + lynKursusChecker()
                + "<br>" + "Bilmærke: " + tilbud.getMærke()
                + "<br>" + "Bilstørrelse: " + tilbud.getStørrelse()
                + "<br>" + "Kørelærer køn: " + tilbud.getKøn()
                + "<br>" + "Tilgængelige dage: " + tilbud.getTilgængeligedage()
                + "<br>" + "Beskrivelse: " + tilbud.getBeskrivelse()

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
