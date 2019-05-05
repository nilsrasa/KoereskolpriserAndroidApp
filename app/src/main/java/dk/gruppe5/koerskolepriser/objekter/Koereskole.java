package dk.gruppe5.koerskolepriser.objekter;

public class Koereskole {
    private String navn;
    private String adresse;
    private int postnummer;
    private int telefonnummer;
    private String email;

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
}
