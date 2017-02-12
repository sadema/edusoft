package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Groepsdeelname;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Opleidingsblad;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Persoon;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
@ImportFactoryQualifier("opleidingsblad")
public class OpleidingsbladImportEntitiesFactory extends BaseImportEntitiesFactory<Opleidingsblad> {

    @Inject
    private JsonHelper jsonHelper;

    @Override
    public Opleidingsblad create(Instance<ImportEntitiesFactory<?>> factories, List<JsonObject> jsonDataList) {
        Opleidingsblad opleidingsblad = new Opleidingsblad();
        JsonObject opleidingsbladJsonObject = jsonDataList.get(0);
        setBladnummer(opleidingsblad, jsonHelper.getStringFields(opleidingsbladJsonObject, Arrays.asList("bladnummer", "opleiding", "naam", "code", "naam_1")));
        return opleidingsblad;
    }

    Function<JsonObject,Long> opleidingsbladKey = person -> {
        return person.getJsonNumber("bladnummer").longValue();
    };

    private void setBladnummer(Opleidingsblad opleidingsblad, Map<String,String> opleidingsbladFieldMap) {
        opleidingsblad.setBladnummer(opleidingsbladFieldMap.get("bladnummer"));
        opleidingsblad.setOpleiding(opleidingsbladFieldMap.get("opleiding"));
        opleidingsblad.setOpleidingsnaam(opleidingsbladFieldMap.get("naam"));
        opleidingsblad.setGroepscode(opleidingsbladFieldMap.get("code"));
        opleidingsblad.setGroepsnaam(opleidingsbladFieldMap.get("naam_1"));
    }

}
