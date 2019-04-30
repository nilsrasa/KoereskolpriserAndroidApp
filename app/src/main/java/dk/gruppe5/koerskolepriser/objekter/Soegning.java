package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

public class Soegning implements Parcelable{
    private String kørekort_type;
    private String postnummer;
    private String pris;

    private boolean avanceret;

    private boolean lynkursus;
    private boolean mand;
    private boolean kvinde;
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
        this.postnummer = parcel.readString();
        this.pris = parcel.readString();
        this.avanceret = parcel.readByte() != 0;

        if (avanceret){
            this.lynkursus = parcel.readByte() != 0;
            this.mand = parcel.readByte() != 0;
            this.kvinde = parcel.readByte() != 0;
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

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
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

    public boolean isMand() {
        return mand;
    }

    public void setMand(boolean mand) {
        this.mand = mand;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public void setKvinde(boolean kvinde) {
        this.kvinde = kvinde;
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

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(kørekort_type);
        parcel.writeString(postnummer);
        parcel.writeString(pris);
        parcel.writeByte((byte) ((avanceret)?1:0));

        if (avanceret) {
            parcel.writeByte((byte) ((lynkursus)?1:0));
            parcel.writeByte((byte) ((mand)?1:0));
            parcel.writeByte((byte) ((kvinde)?1:0));
            parcel.writeString(mærke);
            parcel.writeString(størrelse);
            parcel.writeString(ønskedage);
        }
    }
}