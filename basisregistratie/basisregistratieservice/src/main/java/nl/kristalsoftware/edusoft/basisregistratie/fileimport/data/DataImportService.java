package nl.kristalsoftware.edusoft.basisregistratie.fileimport.data;

import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportEntitiesFactory;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport.ImportFactorySelector;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.Database;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.CollectionDocument;
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
import java.util.function.Function;

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
    private Instance<CollectionDocument> collectionDocuments;

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

    private CollectionDocument getCollectionDocument(String collectionName) {
        DatabaseSelector qualifier = new DatabaseSelector(collectionName);
        return collectionDocuments.select(qualifier).get();
    }

    private ImportEntitiesFactory getImportEntityFactory(String collectionName) {
        ImportFactorySelector qualifier = new ImportFactorySelector(collectionName);
        return factories.select(qualifier).get();
    }

    public JsonArray getJsonArrayFromData(String jsonData, String elementName) {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
        JsonArray jsonArray = jsonReader.readObject().getJsonArray(elementName);
        jsonReader.close();
        return jsonArray;
    }

    public void processJsonData(String databasename, JsonArray jsonArray, String documentCollectionName, Function<JsonObject,Long> key) {
        ImportEntitiesFactory<Persoon> entityFactory = getImportEntityFactory(documentCollectionName);
        List<Persoon> persoon = entityFactory.create(factories, jsonArray.stream().map(val -> (JsonObject) val), key);
        persoon.stream().forEach(p -> {
            System.out.println(p.getAchternaam() + " " + p.getDeelnemer().getDeelnemernummer());
        });
//        Map<Long,List<JsonObject>> personMap = onderwijsproductArray.stream()
//                .map(val -> (JsonObject) val)
//                .collect(Collectors.groupingBy(personKey));
//        CollectionDocument databaseDocument = getCollectionDocument(databasename);
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
