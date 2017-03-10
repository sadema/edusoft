package nl.kristalsoftware.edusoft.basisregistratie.persoon;

import javax.json.JsonNumber;
import java.util.Map;

/**
 * Created by sjoerdadema on 10/03/2017.
 */
public class PersoonFactory extends BaseEntityFactory {

    public void setPersoonData(Persoon persoon, Map<String, Object> personFieldMap) {
        persoon.setAchternaam(getString(personFieldMap.get("achternaam")));
        persoon.setGeboortedatum(getString(personFieldMap.get("geboortedatum")));
        persoon.setRoepnaam(getString(personFieldMap.get("roepnaam")));
        persoon.setVoorletters(getString(personFieldMap.get("voorletters")));

        Deelnemer deelnemer = new Deelnemer();
        deelnemer.setDeelnemernummer(((JsonNumber) personFieldMap.get("deelnemernummer")).longValue());
        deelnemer.setRegistratiedatum(getString(personFieldMap.get("registratiedatum")));
        persoon.setDeelnemer(deelnemer);
    }
}