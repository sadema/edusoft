package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import nl.kristalsoftware.edusoft.basisregistratie.main.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by sjoerdadema on 01/12/16.
 */
@RequestScoped
@Path("import")
@Consumes("application/json")
@Produces("application/json")
public class ImportResource extends BaseResource {

    @Inject
    private ImportFileProcessor importFileProcessor;

    public ImportResource() {
    }

    @GET
    @Path("persoon")
    public JsonObject processPersoon() {
        return importFileProcessor.process("2personen.json", SystemConfig.getPersoonDatabasename());
    }

    @GET
    @Path("onderwijsproduct")
    public JsonObject processOnderwijsproduct() {
        return importFileProcessor.process("onderwijsproduct.json", SystemConfig.getOnderwijsproductDatabasename());
    }

}
