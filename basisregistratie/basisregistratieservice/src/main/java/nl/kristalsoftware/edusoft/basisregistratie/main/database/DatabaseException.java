package nl.kristalsoftware.edusoft.basisregistratie.main.database;

/**
 * Created by sjoerdadema on 10/02/2017.
 */
public class DatabaseException extends Exception {
    public DatabaseException() {
        super();
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    protected DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
