package nl.kristalsoftware.edusoft.basisregistratie.fileimport.data;

/**
 * Created by sjoerdadema on 10/02/2017.
 */
public class DataImportException extends Exception {
    public DataImportException() {
        super();
    }

    public DataImportException(String message) {
        super(message);
    }

    public DataImportException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataImportException(Throwable cause) {
        super(cause);
    }

    protected DataImportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
