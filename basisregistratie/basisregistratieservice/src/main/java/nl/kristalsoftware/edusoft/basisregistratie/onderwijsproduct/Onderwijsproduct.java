package nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct;

/**
 * Created by sjoerdadema on 01/02/2017.
 */
public class Onderwijsproduct {

    private String id;

    private OnderwijsproductStatus status;

    private String titel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OnderwijsproductStatus getStatus() {
        return status;
    }

    public void setStatus(OnderwijsproductStatus status) {
        this.status = status;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
