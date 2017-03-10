package nl.kristalsoftware.edusoft.basisregistratie.fileimport.persoon;

import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.BaseImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportFactoryQualifier;
import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Groepsdeelname;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Persoon;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.PersoonFactory;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
@ImportFactoryQualifier("persoon")
public class PersoonImportEntitiesFactory extends BaseImportEntitiesFactory<Persoon> {

    @Inject
    private JsonHelper jsonHelper;

    @Inject
    private PersoonFactory persoonFactory;

    @Override
    public Persoon create(Instance<ImportEntitiesFactory<?>> factories, List<JsonObject> jsonDataList) {
        Persoon persoon = new Persoon();
        JsonObject personJsonObject = jsonDataList.get(0);
        persoonFactory.setPersoonData(persoon, jsonHelper.getFields(personJsonObject, Arrays.asList("achternaam", "geboortedatum", "roepnaam", "voorletters", "deelnemernummer", "registratiedatum")));
        ImportEntitiesFactory groepsdeelnameFactory =  getImportEntityFactory(factories, "groepsdeelname");
        List<Groepsdeelname> groepsdeelnameList = groepsdeelnameFactory.create(factories, jsonDataList.stream(), groepsdeelnameKey);
        persoon.setGroepsdeelnames(groepsdeelnameList);
        return persoon;
    }

//    private void setPersoonData(Persoon persoon, Map<String,Object> personFieldMap) {
//        persoon.setAchternaam((String) personFieldMap.get("achternaam"));
//        persoon.setGeboortedatum((String) personFieldMap.get("geboortedatum"));
//        persoon.setRoepnaam((String) personFieldMap.get("roepnaam"));
//        persoon.setVoorletters((String) personFieldMap.get("voorletters"));
//
//        Deelnemer deelnemer = new Deelnemer();
//        deelnemer.setDeelnemernummer(((JsonNumber) personFieldMap.get("deelnemernummer")).longValue());
//        deelnemer.setRegistratiedatum((String) personFieldMap.get("registratiedatum"));
//        persoon.setDeelnemer(deelnemer);
//    }

    Function<JsonObject,Long> groepsdeelnameKey = person -> {
        return person.getJsonNumber("groepsdeelname").longValue();
    };


}
