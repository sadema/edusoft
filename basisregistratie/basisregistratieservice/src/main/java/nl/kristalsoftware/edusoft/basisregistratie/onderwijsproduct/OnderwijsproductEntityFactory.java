package nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct;

import nl.kristalsoftware.edusoft.basisregistratie.main.EntityFactory;

import javax.json.JsonObject;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjoerdadema on 16/02/2017.
 */
public class OnderwijsproductEntityFactory implements EntityFactory<Onderwijsproduct> {

    public Onderwijsproduct create(JsonObject jsonDocument) {
        Onderwijsproduct onderwijsproduct = new Onderwijsproduct();
        Optional<OnderwijsproductStatus> status = OnderwijsproductStatus.findByString(jsonDocument.getString("status"));
        if (status.isPresent()) {
            onderwijsproduct.setStatus(status.get());
        }
        onderwijsproduct.setTitel(jsonDocument.getString("titel"));
        return onderwijsproduct;
    }

    @Override
    public Onderwijsproduct create(List<JsonObject> jsonDataList) {
        return null;
    }
}
