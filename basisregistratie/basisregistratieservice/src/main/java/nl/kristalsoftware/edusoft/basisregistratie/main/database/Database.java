package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import nl.kristalsoftware.edusoft.basisregistratie.main.SystemConfig;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonString;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sjoerdadema on 09/02/2017.
 */
public class Database {

    @Inject
    private Client client;

    private final String couchdbUrl;

    public Database() {
        couchdbUrl = SystemConfig.getCouchdbUrl();
    }

    public boolean databaseExists(String dbName) {
        boolean databaseExists = true;
        WebTarget target = client.target(couchdbUrl + "_all_dbs");
//        try {
        JsonArray dbArr = target.request().accept(MediaType.APPLICATION_JSON_TYPE).get(JsonArray.class);
        System.out.println("Databases: " + dbArr.toString());
        if (dbArr.stream().map(db -> (JsonString) db).filter(db -> db.getString().equals(dbName)).count() == 0) {
            databaseExists = false;
        }
//        } finally {
//            client.close();
//        }
        return databaseExists;
    }

    public boolean createDatabase(String dbName) {
//        boolean databaseCreated = false;
//        WebTarget target = client.target(couchdbUrl).path(dbName);
//        System.out.println(target.getUri().toString());
//        Response response = null;
//        try {
//            response = target.request().put(Entity.text(""));
//            System.out.println("++++++++++" + response.getStatus());
//            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
//                databaseCreated = true;
//            }
//        } finally {
//            if (response != null) {
//                response.close();
//            }
//        }
//        return databaseCreated;
        return true;
    }


}
