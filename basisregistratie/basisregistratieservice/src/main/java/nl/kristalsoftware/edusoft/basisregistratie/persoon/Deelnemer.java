package nl.kristalsoftware.edusoft.basisregistratie.persoon;

/**
 * Created by sjoerdadema on 17/02/2017.
 */
public class Deelnemer {

    private long deelnemernummer;

    private String registratiedatum;

    public long getDeelnemernummer() {
        return deelnemernummer;
    }

    public void setDeelnemernummer(long deelnemernummer) {
        this.deelnemernummer = deelnemernummer;
    }

    public String getRegistratiedatum() {
        return registratiedatum;
    }

    public void setRegistratiedatum(String registratiedatum) {
        this.registratiedatum = registratiedatum;
    }
}
