package nl.kristalsoftware.edusoft.basisregistratie.fileimport.main;

import nl.kristalsoftware.edusoft.basisregistratie.main.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import java.util.function.Function;

/**
 * Created by sjoerdadema on 01/12/16.
 */
@RequestScoped
@Path("import")
@Consumes("application/json")
@Produces("application/json")
public class ImportResource extends BaseResource {

    @Inject
    private ImportFileController importFileController;

    private final String databaseName;

    public ImportResource() {
        this.databaseName = SystemConfig.getDatabasename();
    }

    @GET
    @Path("persoon")
    public JsonObject processPersoon() {
        return importFileController.process("2personen.json", this.databaseName, "persoon", persoonidKey);
    }

    @GET
    @Path("onderwijsproduct")
    public JsonObject processOnderwijsproduct() {
        return importFileController.process("onderwijsproduct.json", this.databaseName, "onderwijsproduct", persoonidKey);
    }

    Function<JsonObject,Long> persoonidKey = jsonData -> {
        return jsonData.getJsonNumber("id").longValue();
    };

}
