package nl.kristalsoftware.edusoft.basisregistratie.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by sjoerdadema on 20/01/2017.
 */
public class BaseResource {

    protected Client client;

    private String databaseUrl;

    protected BaseResource() {
        client = ClientBuilder.newClient();
        databaseUrl = SystemConfig.onderwijsproductDatabaseUrl;
    }

    public <T> T doGet(Class<T> retType, String path) {
        WebTarget target = client.target(databaseUrl + path);
        System.out.println(databaseUrl + path);
        T retVal = target.request().accept(MediaType.APPLICATION_JSON_TYPE).get(retType);
        client.close();
        return retVal;
    }

}
