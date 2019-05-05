package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

import dk.gruppe5.koerskolepriser.R;

public class Soegning implements Parcelable{
    private String kørekort_type;
    private int postnummer;
    private int pris;

    private boolean avanceret;

    private boolean lynkursus;
    private String køn;
    private String mærke;
    private String størrelse;
    private String ønskedage;

    public static final Creator<Soegning> CREATOR = new Creator<Soegning>() {
        @Override
        public Soegning createFromParcel(Parcel parcel) {
            return new Soegning(parcel);
        }

        @Override
        public Soegning[] newArray(int i) {
            return new Soegning[i];
        }
    };

    public Soegning(){
        avanceret = false;
    }

    public Soegning(Parcel parcel){
        this.kørekort_type = parcel.readString();
        this.postnummer = parcel.readInt();
        this.pris = parcel.readInt();
        this.avanceret = parcel.readByte() != 0;

        if (avanceret){
            this.lynkursus = parcel.readByte() != 0;
            this.køn = parcel.readString();
            this.mærke = parcel.readString();
            this.størrelse = parcel.readString();
            this.ønskedage = parcel.readString();
        }
    }

    public String getKørekort_type() {
        return kørekort_type;
    }

    public void setKørekort_type(String kørekort_type) {
        this.kørekort_type = kørekort_type;
    }

    public boolean isAvanceret() {
        return avanceret;
    }

    public void setAvanceret(boolean avanceret) {
        this.avanceret = avanceret;
    }

    public boolean isLynkursus() {
        return lynkursus;
    }

    public void setLynkursus(boolean lynkursus) {
        this.lynkursus = lynkursus;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(String størrelse) {
        this.størrelse = størrelse;
    }

    public String getØnskedage() {
        return ønskedage;
    }

    public void setØnskedage(String ønskedage) {
        this.ønskedage = ønskedage;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getKøn() {
        return køn;
    }

    public void setKøn(String køn) {
        this.køn = køn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public boolean matcher(PakkeTest pakke){
        boolean matcher = false;
        TilbudTilBruger tilbud = pakke.getTilbud();

        matcher = (tilbud.getKørekort_type().equals(getKørekort_type()));
        if (!matcher) return false;
        matcher = (pakke.getKøreskole().getPostnummer() == getPostnummer());
        if (!matcher) return false;
        matcher = (tilbud.getPris() == getPris());
        if (!matcher) return false;

        if (isAvanceret()){
            matcher = (getKøn().equals("Begge")) ||
                    (getKøn().toLowerCase().equals(tilbud.getKøn().toLowerCase()));
            if (!matcher) return false;
            matcher = (!isLynkursus() || isLynkursus() == (tilbud.getLynkursus() == 1));
            if (!matcher) return false;
            matcher = (getMærke().equals("Alle")) ||
                    (getMærke().toLowerCase().equals(tilbud.getMærke().toLowerCase()));
            if (!matcher) return false;
            matcher = (getStørrelse().equals("Alle")) ||
                    (getStørrelse().toLowerCase().equals(tilbud.getStørrelse().toLowerCase()));
            if (!matcher) return false;
            //TODO ønskedage dage
        }

        return true;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(kørekort_type);
        parcel.writeInt(postnummer);
        parcel.writeInt(pris);
        parcel.writeByte((byte) ((avanceret)?1:0));

        if (avanceret) {
            parcel.writeByte((byte) ((lynkursus)?1:0));
            parcel.writeString(køn);
            parcel.writeString(mærke);
            parcel.writeString(størrelse);
            parcel.writeString(ønskedage);
        }
    }

    @Override
    public String toString() {
        return "Soegning{" +
                "kørekort_type='" + kørekort_type + '\'' +
                ", postnummer=" + postnummer +
                ", pris=" + pris +
                ", avanceret=" + avanceret +
                ", lynkursus=" + lynkursus +
                ", køn='" + køn + '\'' +
                ", mærke='" + mærke + '\'' +
                ", størrelse='" + størrelse + '\'' +
                ", ønskedage='" + ønskedage + '\'' +
                '}';
    }
}
