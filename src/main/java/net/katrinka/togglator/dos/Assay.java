package net.katrinka.togglator.dos;

import lombok.Data;
import lombok.NonNull;

/**
 * Assays exist as part of an Operational Region.
 * Albumin is ALB in Central EU and UK
 * Albumin is 200 in US
 * Albumin is 1001 (display code is ALB) in Cortex
 */
@Data
class Assay {
    @NonNull private Analyte analyte;
    @NonNull private OperationalRegion operationalRegion;
    @NonNull private String assayCode;
}
