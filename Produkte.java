package Datenbanken;

public class Produkte {

    public int id;
    public int artikelnummer;
    public String produktname;
    public double preis;
    public String beschreibung;
    public int anzahl;



    public Produkte(int id, int artikelnummer, String produktname, double preis, String beschreibung, int anzahl) {
        this.id = id;
        this.artikelnummer = artikelnummer;
        this.produktname = produktname;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.anzahl = anzahl;
    }

    public Produkte(int artikelnummer, String produktname, double preis, String beschreibung, int anzahl) {
        this.artikelnummer = artikelnummer;
        this.produktname = produktname;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.anzahl = anzahl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
