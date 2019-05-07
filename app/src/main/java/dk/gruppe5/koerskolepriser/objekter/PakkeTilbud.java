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
        return "PakkeTilbud{" +
                "tilbud=" + tilbud.toString() +
                ", køreskole=" + køreskole.toString() +
                '}';
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
