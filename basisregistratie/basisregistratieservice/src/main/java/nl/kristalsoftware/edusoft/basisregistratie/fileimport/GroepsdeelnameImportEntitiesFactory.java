package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Deelnemer;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Groepsdeelname;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Opleidingsblad;
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
@ImportFactoryQualifier("groepsdeelname")
public class GroepsdeelnameImportEntitiesFactory extends BaseImportEntitiesFactory<Groepsdeelname> {

    @Inject
    private JsonHelper jsonHelper;

    @Override
    public Groepsdeelname create(Instance<ImportEntitiesFactory<?>> factories, List<JsonObject> jsonDataList) {
        Groepsdeelname groepsdeelname = new Groepsdeelname();
        JsonObject groepsdeelnameJsonObject = jsonDataList.get(0);
        setGroepsdeelname(groepsdeelname, jsonHelper.getStringFields(groepsdeelnameJsonObject, Arrays.asList("begindatum", "einddatum", "volgnummer")));
        ImportEntitiesFactory opleidingsbladFactory =  getImportEntityFactory(factories, "opleidingsblad");
        List<Opleidingsblad> opleidingsbladList = opleidingsbladFactory.create(factories, jsonDataList.stream(), opleidingsbladKey);
        groepsdeelname.setOpleidingsbladList(opleidingsbladList);
        return groepsdeelname;
    }

    Function<JsonObject,Long> opleidingsbladKey = person -> {
        return person.getJsonNumber("bladnummer").longValue();
    };

    private Groepsdeelname setGroepsdeelname(Groepsdeelname groepsdeelname, Map<String,String> groepsdeelnameFieldMap) {
        groepsdeelname.setBegindatum(groepsdeelnameFieldMap.get("begindatum"));
        groepsdeelname.setEinddatum(groepsdeelnameFieldMap.get("einddatum"));
        groepsdeelname.setVolgnummer(groepsdeelnameFieldMap.get("volgnummer"));
        return groepsdeelname;
    }

}
