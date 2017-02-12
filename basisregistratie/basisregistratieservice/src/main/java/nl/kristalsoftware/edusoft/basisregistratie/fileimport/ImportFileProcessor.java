package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import nl.kristalsoftware.edusoft.basisregistratie.fileimport.data.DataHelper;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.data.DataImportException;
import nl.kristalsoftware.edusoft.basisregistratie.fileimport.data.DataImportService;
import nl.kristalsoftware.edusoft.basisregistratie.main.database.Database;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;

/**
 * Created by sjoerdadema on 14/02/2017.
 */
public class ImportFileProcessor {

    @Inject
    private DataHelper importData;

    @Inject
    private DataImportService dataImportService;

    @Inject
    private Database database;

    public JsonObject process(String filename, String databasename) {
        JsonObject processStatus = Json.createObjectBuilder().add("status", "ok").build();
        try {
            String data = dataImportService.getDataFromFile(filename);
            if (database.databaseExists(databasename)) {
                throw new DataImportException(databasename + " exists");
            }
            else {
                if (!database.createDatabase(databasename)) {
                    throw new DataImportException("cannot create " + databasename);
                }
            }
            dataImportService.processData(databasename, data);
        } catch (IOException e) {
            processStatus = Json.createObjectBuilder().add("error", e.getMessage()).build();
        } catch (DataImportException e) {
            processStatus = Json.createObjectBuilder().add("error", e.getMessage()).build();
        }
        return processStatus;
    }
}
