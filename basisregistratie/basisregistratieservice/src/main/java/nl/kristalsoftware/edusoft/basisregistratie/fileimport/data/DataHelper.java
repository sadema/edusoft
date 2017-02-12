package nl.kristalsoftware.edusoft.basisregistratie.fileimport.data;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonString;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * Created by sjoerdadema on 04/02/2017.
 */
public class DataHelper {

    /**
     * Retrieve a file with specified name
     */
    public URL getUrlFromResource(String filename) {
        ClassLoader cl = getClass().getClassLoader();
        return cl.getResource(filename);
    };

    public String getData(URL url) throws IOException {
        File file = new File(url.getFile());
        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        System.out.println(content);
        return content;
    }

}
