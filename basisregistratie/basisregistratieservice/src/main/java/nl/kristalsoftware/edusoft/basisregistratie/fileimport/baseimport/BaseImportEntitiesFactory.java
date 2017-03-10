package nl.kristalsoftware.edusoft.basisregistratie.fileimport.baseimport;

import javax.enterprise.inject.Instance;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sjoerdadema on 21/02/2017.
 */
public abstract class BaseImportEntitiesFactory<T> implements ImportEntitiesFactory<T> {

    @Override
    public List<T> create(Instance<ImportEntitiesFactory<?>> factories, Stream<JsonObject> stream, Function<JsonObject,Long> keyFunc) {
        List<T> list = new ArrayList<>();
        Map<Long,List<JsonObject>> dataMap = groupingByNumber(stream, keyFunc);
        dataMap.keySet().stream().forEach(key -> {
            list.add(create(factories, dataMap.get(key)));
        });
        return list;
    }

    public ImportEntitiesFactory getImportEntityFactory(Instance<ImportEntitiesFactory<?>> factories, String collectionName) {
        ImportFactorySelector qualifier = new ImportFactorySelector(collectionName);
        return factories.select(qualifier).get();
    }

    private Map<Long,List<JsonObject>> groupingByNumber(Stream<JsonObject> stream, Function<JsonObject,Long> key) {
        return stream
                .map(val -> (JsonObject) val)
                .collect(Collectors.groupingBy(key));

    }

    public abstract T create(Instance<ImportEntitiesFactory<?>> factories, List<JsonObject> jsonDataList);

}
