package nl.kristalsoftware.edusoft.basisregistratie.main;

import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sjoerdadema on 17/02/2017.
 */
public class JsonHelper {

    public Map<String, Object> getFields(JsonObject jsonObject, List<String> fieldList) {
        Map<String,Object> fieldMap = new HashMap<>();
//        fieldList.stream().filter(field -> jsonObject.getJsonString(field) == null).collect(Collectors.toMap(Function.identity(), String::new));
        fieldList.stream().forEach(field -> {
            JsonValue value = jsonObject.get(field);
            if (value != null) {
                JsonValue.ValueType type = value.getValueType();
                switch (type) {
                    case STRING:
                        fieldMap.put(field, jsonObject.getJsonString(field).getString());
                        break;
                    case NUMBER:
                        fieldMap.put(field, jsonObject.getJsonNumber(field));
                        break;
                }
            }
        });
        return fieldMap;
    }
}
