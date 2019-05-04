package dk.gruppe5.koerskolepriser.objekter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TilbudTilBruger implements Parcelable{
    @Expose
    @SerializedName("koreskole_id")
    private String køreskole_id;
    @Expose
    @SerializedName("pris")
    private String pris;
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

    public static final Creator<TilbudTilBruger> CREATOR = new Creator<TilbudTilBruger>() {
        @Override
        public TilbudTilBruger createFromParcel(Parcel parcel) {
            return new TilbudTilBruger(parcel);
        }

        @Override
        public TilbudTilBruger[] newArray(int i) {
            return new TilbudTilBruger[i];
        }
    };

    public TilbudTilBruger(){ }

    public TilbudTilBruger(Parcel parcel){
        this.køreskole_id = parcel.readString();
        this.pris = parcel.readString();
        this.kørekort_type = parcel.readString();

        this.lynkursus = parcel.readInt();
        this.mærke = parcel.readString();
        this.størrelse = parcel.readString();
        this.køn = parcel.readString();
        this.beskrivelse = parcel.readString();
    }

    public String getKørekort_type() {
        return kørekort_type;
    }

    public void setKørekort_type(String kørekort_type) {
        this.kørekort_type = kørekort_type;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
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

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(køreskole_id);
        parcel.writeString(pris);
        parcel.writeString(kørekort_type);

        parcel.writeInt(lynkursus);
        parcel.writeString(mærke);
        parcel.writeString(størrelse);
        parcel.writeString(køn);
        parcel.writeString(beskrivelse);
    }
}
