package nl.kristalsoftware.edusoft.basisregistratie.persoon;

import nl.kristalsoftware.edusoft.basisregistratie.main.EntityFactory;
import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sjoerdadema on 16/02/2017.
 */
@Deprecated
public class PersoonEntityFactory implements EntityFactory<Persoon> {

    @Inject
    private JsonHelper jsonHelper;

//    @Override
//    public Persoon create(JsonObject jsonDocument) {
//        Persoon persoon = new Persoon();
//        Map<String, String> fieldList = jsonHelper.getFields(jsonDocument, Arrays.asList("achternaam", "geboortedatum", "roepnaam", "voorletters", "deelnemernummer", "registratiedatum"));
//        persoon.setAchternaam(fieldList.get("achternaam"));
//        persoon.setGeboortedatum(fieldList.get("geboortedatum"));
//        persoon.setRoepnaam(fieldList.get("roepnaam"));
//        persoon.setVoorletters(fieldList.get("voorletters"));
//
//        Deelnemer deelnemer = new Deelnemer();
//        deelnemer.setDeelnemernummer(fieldList.get("deelnemernummer"));
//        deelnemer.setRegistratiedatum(fieldList.get("registratiedatum"));
//        persoon.setDeelnemer(deelnemer);
//        return persoon;
//    }

    Function<JsonObject,Long> groepsdeelnameKey = person -> {
        return person.getJsonNumber("groepsdeelname").longValue();
    };

    @Override
    public Persoon create(List<JsonObject> jsonDataList) {
        Persoon persoon = new Persoon();
        JsonObject personJsonObject = jsonDataList.get(0);
        setPersonData(persoon, jsonHelper.getFields(personJsonObject, Arrays.asList("achternaam", "geboortedatum", "roepnaam", "voorletters", "deelnemernummer", "registratiedatum")));
        Map<Long,List<JsonObject>> groepsdeelnameMap = jsonDataList.stream().collect(Collectors.groupingBy(groepsdeelnameKey));
        groepsdeelnameMap.keySet().forEach(key -> {
            Groepsdeelname groepsdeelname = this.create(persoon, groepsdeelnameMap.get(key));
            persoon.getGroepsdeelnames().add(groepsdeelname);
        });
        return persoon;
    }

    private Groepsdeelname create(Persoon persoon, List<JsonObject> jsonDataList) {
        Groepsdeelname groepsdeelname = new Groepsdeelname();
        JsonObject groepsdeelnameJsonObject = jsonDataList.get(0);
        setGroepsdeelname(groepsdeelname, jsonHelper.getFields(groepsdeelnameJsonObject, Arrays.asList("begindatum", "einddatum", "volgnummer")));
        return groepsdeelname;
    }

    private Persoon setPersonData(Persoon persoon, Map<String,Object> personFieldMap) {
        persoon.setAchternaam((String) personFieldMap.get("achternaam"));
        persoon.setGeboortedatum((String) personFieldMap.get("geboortedatum"));
        persoon.setRoepnaam((String) personFieldMap.get("roepnaam"));
        persoon.setVoorletters((String) personFieldMap.get("voorletters"));

        Deelnemer deelnemer = new Deelnemer();
        deelnemer.setDeelnemernummer((Integer) personFieldMap.get("deelnemernummer"));
        deelnemer.setRegistratiedatum((String) personFieldMap.get("registratiedatum"));
        persoon.setDeelnemer(deelnemer);
        return persoon;
    }

    private Groepsdeelname setGroepsdeelname(Groepsdeelname groepsdeelname, Map<String,Object> groepsdeelnameFieldMap) {
        groepsdeelname.setBegindatum((String) groepsdeelnameFieldMap.get("begindatum"));
        groepsdeelname.setEinddatum((String) groepsdeelnameFieldMap.get("einddatum"));
//        groepsdeelname.setVolgnummer((String) groepsdeelnameFieldMap.get("volgnummer"));
        return groepsdeelname;
    }

}
