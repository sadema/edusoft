package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import nl.kristalsoftware.edusoft.basisregistratie.main.SystemConfig;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.Persoon;
import nl.kristalsoftware.edusoft.basisregistratie.persoon.PersoonEntityFactory;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.util.List;

/**
 * Created by sjoerdadema on 14/02/2017.
 */
@DatabaseQualifier("persoon")
public class PersoonCollectionDocument implements CollectionDocument {

    @Inject
    private Client client;

    @Inject
    private PersoonEntityFactory persoonEntityFactory;

//    @Override
//    public int create(int id, JsonObject jsonDocument, String databasename) {
//        int responseStatus = 500;
//        WebTarget target = client.target(SystemConfig.getCouchdbUrl() + databasename + "/" + String.valueOf(id));
//        Persoon persoon = persoonEntityFactory.create(jsonDocument);
//        return responseStatus;
//    }

    @Override
    public int create(Long id, List<JsonObject> personDataList, String databasename) {
        int responseStatus = 500;
        WebTarget target = client.target(SystemConfig.getCouchdbUrl() + databasename + "/" + id);
        Persoon persoon = persoonEntityFactory.create(personDataList);
        return responseStatus;
    }

}
