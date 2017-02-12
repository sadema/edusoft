package nl.kristalsoftware.edusoft.basisregistratie.onderwijsproduct;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by sjoerdadema on 01/02/2017.
 */
public enum OnderwijsproductStatus {

    BESCHIKBAAR("Beschikbaar"),

    VERVALLEN("Vervallen");

    private String value;

    OnderwijsproductStatus(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    public static Optional<OnderwijsproductStatus> findByString(String enumVal) {
        return Arrays.asList(OnderwijsproductStatus.values()).stream().filter(status -> status.value.equals(enumVal)).findFirst();
    }
}
