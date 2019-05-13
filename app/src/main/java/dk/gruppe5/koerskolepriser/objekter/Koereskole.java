package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

public class Koereskole implements Parcelable {
    private String navn;
    private String adresse;
    private int postnummer;
    private int telefonnummer;
    private String email;

    public Koereskole(){}

    protected Koereskole(Parcel in) {
        navn = in.readString();
        adresse = in.readString();
        postnummer = in.readInt();
        telefonnummer = in.readInt();
        email = in.readString();
    }

    public static final Creator<Koereskole> CREATOR = new Creator<Koereskole>() {
        @Override
        public Koereskole createFromParcel(Parcel in) {
            return new Koereskole(in);
        }

        @Override
        public Koereskole[] newArray(int size) {
            return new Koereskole[size];
        }
    };

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Koereskole{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postnummer=" + postnummer +
                ", telefonnummer=" + telefonnummer +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(navn);
        dest.writeString(adresse);
        dest.writeInt(postnummer);
        dest.writeInt(telefonnummer);
        dest.writeString(email);
    }
}
