package nl.kristalsoftware.edusoft.basisregistratie.persoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
public class Groepsdeelname {

    private String begindatum = "";

    private String einddatum = "";

    private String volgnummer = "";

    private List<Opleidingsblad> opleidingsbladList = new ArrayList<>();

    public String getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(String begindatum) {
        this.begindatum = begindatum;
    }

    public String getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(String einddatum) {
        this.einddatum = einddatum;
    }

    public String getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(String volgnummer) {
        this.volgnummer = volgnummer;
    }

    public List<Opleidingsblad> getOpleidingsbladList() {
        return opleidingsbladList;
    }

    public void setOpleidingsbladList(List<Opleidingsblad> opleidingsbladList) {
        this.opleidingsbladList = opleidingsbladList;
    }

}
