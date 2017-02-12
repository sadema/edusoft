package nl.kristalsoftware.edusoft.basisregistratie.fileimport;

import javax.enterprise.inject.Instance;
import javax.json.JsonObject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
public interface ImportEntitiesFactory<T> {

    List<T> create(Instance<ImportEntitiesFactory<?>> factoryInstances, Stream<JsonObject> stream, Function<JsonObject,Long> key);

}
