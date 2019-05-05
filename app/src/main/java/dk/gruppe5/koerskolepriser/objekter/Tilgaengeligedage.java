package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

public class Tilgaengeligedage implements Parcelable {
    int tilgangelig_mandag;
    int tilgangelig_tirsdag;
    int tilgangelig_onsdag;
    int tilgangelig_torsdag;
    int tilgangelig_fredag;
    int tilgangelig_lordag;
    int tilgangelig_sondag;

    public Tilgaengeligedage() {}

    protected Tilgaengeligedage(Parcel in) {
        tilgangelig_mandag = in.readInt();
        tilgangelig_tirsdag = in.readInt();
        tilgangelig_onsdag = in.readInt();
        tilgangelig_torsdag = in.readInt();
        tilgangelig_fredag = in.readInt();
        tilgangelig_lordag = in.readInt();
        tilgangelig_sondag = in.readInt();
    }

    public static final Creator<Tilgaengeligedage> CREATOR = new Creator<Tilgaengeligedage>() {
        @Override
        public Tilgaengeligedage createFromParcel(Parcel in) {
            return new Tilgaengeligedage(in);
        }

        @Override
        public Tilgaengeligedage[] newArray(int size) {
            return new Tilgaengeligedage[size];
        }
    };

    public int getTilgangelig_mandag() {
        return tilgangelig_mandag;
    }

    public void setTilgangelig_mandag(int tilgangelig_mandag) {
        this.tilgangelig_mandag = tilgangelig_mandag;
    }

    public int getTilgangelig_tirsdag() {
        return tilgangelig_tirsdag;
    }

    public void setTilgangelig_tirsdag(int tilgangelig_tirsdag) {
        this.tilgangelig_tirsdag = tilgangelig_tirsdag;
    }

    public int getTilgangelig_onsdag() {
        return tilgangelig_onsdag;
    }

    public void setTilgangelig_onsdag(int tilgangelig_onsdag) {
        this.tilgangelig_onsdag = tilgangelig_onsdag;
    }

    public int getTilgangelig_torsdag() {
        return tilgangelig_torsdag;
    }

    public void setTilgangelig_torsdag(int tilgangelig_torsdag) {
        this.tilgangelig_torsdag = tilgangelig_torsdag;
    }

    public int getTilgangelig_fredag() {
        return tilgangelig_fredag;
    }

    public void setTilgangelig_fredag(int tilgangelig_fredag) {
        this.tilgangelig_fredag = tilgangelig_fredag;
    }

    public int getTilgangelig_lordag() {
        return tilgangelig_lordag;
    }

    public void setTilgangelig_lordag(int tilgangelig_lordag) {
        this.tilgangelig_lordag = tilgangelig_lordag;
    }

    public int getTilgangelig_sondag() {
        return tilgangelig_sondag;
    }

    public void setTilgangelig_sondag(int tilgangelig_sondag) {
        this.tilgangelig_sondag = tilgangelig_sondag;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tilgangelig_mandag);
        dest.writeInt(tilgangelig_tirsdag);
        dest.writeInt(tilgangelig_onsdag);
        dest.writeInt(tilgangelig_torsdag);
        dest.writeInt(tilgangelig_fredag);
        dest.writeInt(tilgangelig_lordag);
        dest.writeInt(tilgangelig_sondag);
    }

    @Override
    public String toString() {
        return "Tilgaengeligedage{" +
                "tilgangelig_mandag=" + tilgangelig_mandag +
                ", tilgangelig_tirsdag=" + tilgangelig_tirsdag +
                ", tilgangelig_onsdag=" + tilgangelig_onsdag +
                ", tilgangelig_torsdag=" + tilgangelig_torsdag +
                ", tilgangelig_fredag=" + tilgangelig_fredag +
                ", tilgangelig_lordag=" + tilgangelig_lordag +
                ", tilgangelig_sondag=" + tilgangelig_sondag +
                '}';
    }
}
