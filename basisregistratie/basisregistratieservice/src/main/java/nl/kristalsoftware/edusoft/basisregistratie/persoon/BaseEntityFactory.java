package nl.kristalsoftware.edusoft.basisregistratie.persoon;

/**
 * Created by sjoerdadema on 10/03/2017.
 */
public class BaseEntityFactory {

    String getString(Object val) {
        return (val != null) ? (String) val : "";
    }

}
