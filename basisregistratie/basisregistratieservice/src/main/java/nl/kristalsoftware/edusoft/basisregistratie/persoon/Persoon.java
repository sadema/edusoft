package nl.kristalsoftware.edusoft.basisregistratie.persoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerdadema on 14/02/2017.
 */
public class Persoon {

    private String achternaam;

    private String geboortedatum;

    private String roepnaam;

    private String voorletters;

    private Deelnemer deelnemer;

    private List<Groepsdeelname> groepsdeelnames = new ArrayList<>();

    public List<Groepsdeelname> getGroepsdeelnames() {
        return groepsdeelnames;
    }

    public void setGroepsdeelnames(List<Groepsdeelname> groepsdeelnames) {
        this.groepsdeelnames = groepsdeelnames;
    }

    public Deelnemer getDeelnemer() {
        return deelnemer;
    }

    public void setDeelnemer(Deelnemer deelnemer) {
        this.deelnemer = deelnemer;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getRoepnaam() {
        return roepnaam;
    }

    public void setRoepnaam(String roepnaam) {
        this.roepnaam = roepnaam;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }
}
