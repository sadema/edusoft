package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import nl.kristalsoftware.edusoft.basisregistratie.main.SystemConfig;
import nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct.Onderwijsproduct;
import nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct.OnderwijsproductStatus;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjoerdadema on 09/02/2017.
 */
public interface CollectionDocument {

//    int create(int id, JsonObject jsonDocument, String databasename);

    int create(Long id, List<JsonObject> personDataList, String databasename );
}
