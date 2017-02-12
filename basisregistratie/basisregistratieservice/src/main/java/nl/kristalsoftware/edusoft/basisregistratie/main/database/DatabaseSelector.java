package nl.kristalsoftware.edusoft.basisregistratie.main.database;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by sjoerdadema on 15/02/2017.
 */
public class DatabaseSelector extends AnnotationLiteral<DatabaseQualifier> implements DatabaseQualifier {

    private String database;

    public DatabaseSelector(String database) {
        this.database = database;
    }

    @Override
    public String value() {
        return database;
    }
}
