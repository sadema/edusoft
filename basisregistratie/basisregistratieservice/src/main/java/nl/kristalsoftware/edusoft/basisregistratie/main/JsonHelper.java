package nl.kristalsoftware.edusoft.basisregistratie.main;

import javax.json.JsonObject;
import javax.json.JsonString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sjoerdadema on 17/02/2017.
 */
public class JsonHelper {

    public Map<String, String> getStringFields(JsonObject jsonObject, List<String> fieldList) {
        Map<String,String> fieldMap = new HashMap<>();
//        fieldList.stream().filter(field -> jsonObject.getJsonString(field) == null).collect(Collectors.toMap(Function.identity(), String::new));
        fieldList.stream().forEach(field -> {
            JsonString val = jsonObject.getJsonString(field);
            if (val == null) {
                fieldMap.put(field, "");
            }
            else {
                fieldMap.put(field, val.getString());
            }
        });
        return fieldMap;
    }
}
