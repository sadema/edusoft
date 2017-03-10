package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import nl.kristalsoftware.edusoft.basisregistratie.main.SystemConfig;
import nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct.Onderwijsproduct;
import nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct.OnderwijsproductEntityFactory;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sjoerdadema on 14/02/2017.
 */
@DatabaseQualifier("onderwijsproduct")
public class OnderwijsproductCollectionDocument extends BaseDatabaseDocument<Onderwijsproduct> implements CollectionDocument {

    @Inject
    private Client client;

    @Inject
    private OnderwijsproductEntityFactory onderwijsproductEntityFactory;

    public int create(int id, JsonObject jsonDocument, String databasename) {
        int responseStatus = 500;
        WebTarget target = client.target(SystemConfig.getCouchdbUrl() + databasename + "/" + String.valueOf(id));
        Onderwijsproduct onderwijsproduct = onderwijsproductEntityFactory.create(jsonDocument);
        responseStatus = this.createDocument(target, id, onderwijsproduct);
        if ( responseStatus == Response.Status.CREATED.getStatusCode()) {
            System.out.println("Document with id :" + id + " and title: " + onderwijsproduct.getTitel() + " created!");
        } else {
            System.out.println("ERROR: Could not create document with id: " + id);
        }
        return responseStatus;
    }

    @Override
    public int create(Long id, List<JsonObject> personDataList, String databasename) {
        return 0;
    }

}
