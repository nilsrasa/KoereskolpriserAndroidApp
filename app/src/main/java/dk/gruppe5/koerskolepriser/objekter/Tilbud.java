package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tilbud implements Parcelable{
    @Expose
    @SerializedName("koreskole_id")
    private String køreskole_id;
    @Expose
    @SerializedName("pris")
    private int pris;
    @Expose
    @SerializedName("korekort_type")
    private String kørekort_type;
    @Expose
    @SerializedName("lynkursus")
    private int lynkursus;
    @Expose
    @SerializedName("bilmarke")
    private String mærke;
    @Expose
    @SerializedName("bilstorrelse")
    private String størrelse;
    @Expose
    @SerializedName("kon")
    private String køn;
    @Expose
    @SerializedName("beskrivelse")
    private String beskrivelse;
    @Expose
    @SerializedName("tilgangeligeDage")
    private Tilgaengeligedage tilgængeligedage;


    public static final Creator<Tilbud> CREATOR = new Creator<Tilbud>() {
        @Override
        public Tilbud createFromParcel(Parcel parcel) {
            return new Tilbud(parcel);
        }

        @Override
        public Tilbud[] newArray(int i) {
            return new Tilbud[i];
        }
    };

    public Tilbud(){ }

    protected Tilbud(Parcel parcel){
        this.køreskole_id = parcel.readString();
        this.pris = parcel.readInt();
        this.kørekort_type = parcel.readString();
        this.lynkursus = parcel.readInt();
        this.mærke = parcel.readString();
        this.størrelse = parcel.readString();
        this.køn = parcel.readString();
        this.beskrivelse = parcel.readString();
        this.tilgængeligedage = parcel.readParcelable(Tilgaengeligedage.class.getClassLoader());
    }

    public String getKørekort_type() {
        return kørekort_type;
    }

    public void setKørekort_type(String kørekort_type) {
        this.kørekort_type = kørekort_type;
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

    public String getKøreskole_id() {
        return køreskole_id;
    }

    public void setKøreskole_id(String køreskole_id) {
        this.køreskole_id = køreskole_id;
    }

    public int getLynkursus() {
        return lynkursus;
    }

    public String getKøn() {
        return køn;
    }

    public void setKøn(String køn) {
        this.køn = køn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setLynkursus(int lynkursus) {
        this.lynkursus = lynkursus;
    }

    public Tilgaengeligedage getTilgængeligedage() {
        return tilgængeligedage;
    }

    public void setTilgængeligedage(Tilgaengeligedage tilgængeligedage) {
        this.tilgængeligedage = tilgængeligedage;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(køreskole_id);
        parcel.writeInt(pris);
        parcel.writeString(kørekort_type);
        parcel.writeInt(lynkursus);
        parcel.writeString(mærke);
        parcel.writeString(størrelse);
        parcel.writeString(køn);
        parcel.writeString(beskrivelse);
        parcel.writeParcelable(tilgængeligedage,0);
    }

    @Override
    public String toString() {
        return "<br>" + "Kørekort: " + getKørekort_type()
                + "<br>" + "Pris: " + getPris()
                + "<br>" + "Lynkurs: " + ((lynkursus == 1)? "Ja" : "Nej")
                + "<br>" + "Bilmærke: " + getMærke()
                + "<br>" + "Bilstørrelse: " + getStørrelse()
                + "<br>" + "Kørelærer køn: " + getKøn()
                + "<br>" + "Tilgængelige dage: " + getTilgængeligedage().toString()
                + "<br>" + "Beskrivelse: " + getBeskrivelse();
    }
}
