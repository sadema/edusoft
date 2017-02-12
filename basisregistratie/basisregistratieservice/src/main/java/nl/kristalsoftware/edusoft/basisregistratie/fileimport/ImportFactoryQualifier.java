package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sjoerdadema on 14/02/2017.
 */
@Qualifier
@Target({FIELD, METHOD, PARAMETER, TYPE})
@Retention(RUNTIME)
public @interface ImportFactoryQualifier {

    String value();

}
