package nl.kristalsoftware.edusoft.basisregistratie.fileimport.data;

import nl.kristalsoftware.edusoft.basisregistratie.fileimport.BaseImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.ImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.ImportFactorySelector;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.Database;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.DatabaseDocument;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.DatabaseSelector;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Persoon;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.*;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sjoerdadema on 09/02/2017.
 */
public class DataImportService {

    @Inject
    private DataHelper dataHelper;

    @Inject
    private Database database;

    @Inject
    @Any
    private Instance<DatabaseDocument> databaseDocuments;

    @Inject
    @Any
    private Instance<ImportEntitiesFactory<?>> factories;

    public DataImportService() {
    }

    public String getDataFromFile(String filename) throws IOException {
        String data = "";
        URL url = dataHelper.getUrlFromResource(filename);
        if (url != null) {
            data = dataHelper.getData(url);

        } else {
            throw new IOException(filename + " does not exist");
        }
        return data;
    }

    Function<JsonObject,Long> personKey = person -> {
        return person.getJsonNumber("id").longValue();
    };

    private DatabaseDocument getDatabaseDocument(String databasename) {
        DatabaseSelector qualifier = new DatabaseSelector(databasename);
        return databaseDocuments.select(qualifier).get();
    }

    private ImportEntitiesFactory getImportEntityFactory(String collectionName) {
        ImportFactorySelector qualifier = new ImportFactorySelector(collectionName);
        return factories.select(qualifier).get();
    }

    public void processData(String databasename, String data) {
        JsonReader jsonReader = Json.createReader(new StringReader(data));
        JsonArray personArray = jsonReader.readObject().getJsonArray("items");
        jsonReader.close();
        ImportEntitiesFactory<Persoon> entityFactory = getImportEntityFactory(databasename);
        List<Persoon> persoon = entityFactory.create(factories, personArray.stream().map(val -> (JsonObject) val), personKey);

//        Map<Long,List<JsonObject>> personMap = onderwijsproductArray.stream()
//                .map(val -> (JsonObject) val)
//                .collect(Collectors.groupingBy(personKey));
//        DatabaseDocument databaseDocument = getDatabaseDocument(databasename);
//        personMap.keySet().stream().forEach(personKey -> {
//            databaseDocument.create(personKey, personMap.get(personKey), databasename);
//        });

//        onderwijsproductArray.stream()
//                .filter(val -> val.getValueType() == JsonValue.ValueType.OBJECT)
//                .map(val -> (JsonObject) val)
//                .forEach(jsonDocument -> {
//                    databaseDocument.create(jsonDocument.getInt("id"), jsonDocument, databasename);
//                });
    }
}
