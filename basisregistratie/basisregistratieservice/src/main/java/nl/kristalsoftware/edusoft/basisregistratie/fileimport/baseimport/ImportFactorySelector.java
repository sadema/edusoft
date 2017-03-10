package nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by sjoerdadema on 15/02/2017.
 */
public class ImportFactorySelector extends AnnotationLiteral<ImportFactoryQualifier> implements ImportFactoryQualifier {

    private String collection;

    public ImportFactorySelector(String collection) {
        this.collection = collection;
    }

    @Override
    public String value() {
        return collection;
    }
}
