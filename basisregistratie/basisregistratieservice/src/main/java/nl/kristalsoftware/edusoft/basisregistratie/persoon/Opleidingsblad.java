package nl.kristalsoftware.edusoft.basisregistratie.persoon;

/**
 * Created by sjoerdadema on 22/02/2017.
 */
public class Opleidingsblad {

    private String bladnummer = "";

    private String opleiding = "";

    private String opleidingsnaam = "";

    private String groepscode = "";

    private String groepsnaam = "";

    public String getBladnummer() {
        return bladnummer;
    }

    public void setBladnummer(String bladnummer) {
        this.bladnummer = bladnummer;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public String getOpleidingsnaam() {
        return opleidingsnaam;
    }

    public void setOpleidingsnaam(String opleidingsnaam) {
        this.opleidingsnaam = opleidingsnaam;
    }

    public String getGroepscode() {
        return groepscode;
    }

    public void setGroepscode(String groepscode) {
        this.groepscode = groepscode;
    }

    public String getGroepsnaam() {
        return groepsnaam;
    }

    public void setGroepsnaam(String groepsnaam) {
        this.groepsnaam = groepsnaam;
    }
}
