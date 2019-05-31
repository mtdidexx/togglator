package net.katrinka.togglator.dos;

import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Analytes are a global concept: There is only 1 version of the analyte globally.
 */
@Data
public class Analyte {
    @NonNull private String analyteCode;
    private Set<Assay> assays = new HashSet<>();

    public Assay fromAnalyte(String assayCode, OperationalRegion region) {
        Assay assay = new Assay(new Analyte(this.getAnalyteCode()), region, assayCode);
        assays.add(assay);
        return assay;
    }
}
