package nl.kristalsoftware.edusoft.basisregistratie.fileimport.persoon;

import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.BaseImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportFactoryQualifier;
import nl.kristalsoftware.edusoft.basisregistratie.main.JsonHelper;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Opleidingsblad;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonNumber;
import javax.json.JsonObject;
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
        setBladnummer(opleidingsblad, jsonHelper.getFields(opleidingsbladJsonObject, Arrays.asList("bladnummer", "opleiding", "naam", "code", "naam_1")));
        return opleidingsblad;
    }

    Function<JsonObject,Long> opleidingsbladKey = person -> {
        return person.getJsonNumber("bladnummer").longValue();
    };

    private void setBladnummer(Opleidingsblad opleidingsblad, Map<String,Object> opleidingsbladFieldMap) {
        opleidingsblad.setBladnummer(((JsonNumber) opleidingsbladFieldMap.get("bladnummer")).intValue());
        opleidingsblad.setOpleiding((String) opleidingsbladFieldMap.get("opleiding"));
        opleidingsblad.setOpleidingsnaam((String) opleidingsbladFieldMap.get("naam"));
        opleidingsblad.setGroepscode((String) opleidingsbladFieldMap.get("code"));
        opleidingsblad.setGroepsnaam((String) opleidingsbladFieldMap.get("naam_1"));
    }

}
