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
    @SerializedName("tilgangeligeDage")
    private String ønskedage;
    @Expose
    @SerializedName("id")
    private int id;

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

    public Tilbud(Parcel parcel){
        this.køreskole_id = parcel.readString();
        this.pris = parcel.readString();
        this.kørekort_type = parcel.readString();

        this.lynkursus = parcel.readInt();
        this.mærke = parcel.readString();
        this.størrelse = parcel.readString();
        this.køn = parcel.readString();
        this.ønskedage = parcel.readString();
        this.id = parcel.readInt();
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

    public int isLynkursus() {
        return lynkursus;
    }

    public void setLynkursus(int lynkursus) {
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
        parcel.writeString(ønskedage);
        parcel.writeInt(id);
    }
}
