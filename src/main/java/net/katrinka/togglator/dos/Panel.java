package net.katrinka.togglator.dos;

import lombok.Data;

import java.util.Set;

@Data
public class Panel {
    private Set<Assay> assays;
    private String panelCode;
    private String panelName;
}
