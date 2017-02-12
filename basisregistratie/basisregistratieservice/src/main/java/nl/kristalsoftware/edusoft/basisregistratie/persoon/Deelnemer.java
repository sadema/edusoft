package nl.kristalsoftware.edusoft.basisregistratie.persoon;

/**
 * Created by sjoerdadema on 17/02/2017.
 */
public class Deelnemer {

    private String deelnemernummer;

    private String registratiedatum;

    public String getDeelnemernummer() {
        return deelnemernummer;
    }

    public void setDeelnemernummer(String deelnemernummer) {
        this.deelnemernummer = deelnemernummer;
    }

    public String getRegistratiedatum() {
        return registratiedatum;
    }

    public void setRegistratiedatum(String registratiedatum) {
        this.registratiedatum = registratiedatum;
    }
}
