package nl.kristalsoftware.edusoft.basisregistratie.main;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sjoerdadema on 08/12/16.
 */
public class SystemConfig {

    private static SystemConfig instance = null;

    public static final String onderwijsproductDatabaseUrl = createOnderwijsproductDatabaseUrl();

    public static final String persoonDatabaseUrl = createPersoonDatabaseUrl();

    private Properties props;

    private SystemConfig() {
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/docker.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot load properties");
        }
    }

    private static SystemConfig getInstance() {
        if (instance == null) {
            return new SystemConfig();
        }
        else {
            return instance;
        }
    }

    public static String getCouchdbUrl() {
        return getInstance().props.getProperty("couchdb_url");
    }

    public static String getOnderwijsproductDatabasename() {
        return getInstance().props.getProperty("onderwijsproduct_databasename");
    }

    public static String getPersoonDatabasename() {
        return getInstance().props.getProperty("persoon_databasename");
    }

    private static String createOnderwijsproductDatabaseUrl() {
        String url = getCouchdbUrl() + getOnderwijsproductDatabasename();
        System.out.println("Url: " + url);
        return url;
    }

    private static String createPersoonDatabaseUrl() {
        String url = getCouchdbUrl() + getPersoonDatabasename();
        System.out.println("Url: " + url);
        return url;
    }

}
