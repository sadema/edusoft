package nl.kristalsoftware.edusoft.basisregistratie.main;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by sjoerdadema on 04/02/2017.
 */
public class ClientProvider {

    @Produces
    @ApplicationScoped
    Client createClient() {
        System.out.println("++++++++++Create Client");
        return ClientBuilder.newClient();
    }
}
