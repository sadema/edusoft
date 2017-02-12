package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Deelnemer;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Groepsdeelname;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Persoon;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
@ImportFactoryQualifier("persoon")
public class PersoonImportEntitiesFactory extends BaseImportEntitiesFactory<Persoon> {

    @Inject
    private JsonHelper jsonHelper;

    @Override
    public Persoon create(Instance<ImportEntitiesFactory<?>> factories, List<JsonObject> jsonDataList) {
        Persoon persoon = new Persoon();
        JsonObject personJsonObject = jsonDataList.get(0);
        setPersonData(persoon, jsonHelper.getStringFields(personJsonObject, Arrays.asList("achternaam", "geboortedatum", "roepnaam", "voorletters", "deelnemernummer", "registratiedatum")));
        ImportEntitiesFactory groepsdeelnameFactory =  getImportEntityFactory(factories, "groepsdeelname");
        List<Groepsdeelname> groepsdeelnameList = groepsdeelnameFactory.create(factories, jsonDataList.stream(), groepsdeelnameKey);
        persoon.setGroepsdeelnames(groepsdeelnameList);
        return persoon;
    }

    private void setPersonData(Persoon persoon, Map<String,String> personFieldMap) {
        persoon.setAchternaam(personFieldMap.get("achternaam"));
        persoon.setGeboortedatum(personFieldMap.get("geboortedatum"));
        persoon.setRoepnaam(personFieldMap.get("roepnaam"));
        persoon.setVoorletters(personFieldMap.get("voorletters"));

        Deelnemer deelnemer = new Deelnemer();
        deelnemer.setDeelnemernummer(personFieldMap.get("deelnemernummer"));
        deelnemer.setRegistratiedatum(personFieldMap.get("registratiedatum"));
        persoon.setDeelnemer(deelnemer);
    }

    Function<JsonObject,Long> groepsdeelnameKey = person -> {
        return person.getJsonNumber("groepsdeelname").longValue();
    };


}
