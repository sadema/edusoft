package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by sjoerdadema on 16/02/2017.
 */
public class BaseDatabaseDocument<T> {

    protected int createDocument(WebTarget target, int id, T entity) {
        int responseStatus = 500;
        Response response = null;
        try {
            response = target.request().put(Entity.json(entity));
            responseStatus = response.getStatus();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responseStatus;

    }
}
