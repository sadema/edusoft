package nl.kristalsoftware.edusoft.basisregistratie.main;

import javax.json.JsonObject;
import java.util.List;

/**
 * Created by sjoerdadema on 16/02/2017.
 */
public interface EntityFactory<T> {

    T create(JsonObject jsonDocument);

    T create(List<JsonObject> jsonDataList);

}
