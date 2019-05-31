package net.katrinka.togglator.dos;

import org.junit.Test;

public class AlbuminTest {
    @Test
    public void albuminIsAGlobalAnalyte() {
        var albumin = new Analyte("ALBUMIN");
        var clabAlbumin = new Assay(albumin, OperationalRegion.CENTRAL_EUROPE, "ALB");
        var usAlbumin = new Assay(albumin, OperationalRegion.USA, "200");
        assert clabAlbumin.getAnalyte().equals(usAlbumin.getAnalyte());
    }

    @Test
    public void assaysFromAnalyte() {
        var fructosamine = new Analyte("Fructosamine");
        var clabFruc = fructosamine.fromAnalyte("FRUC", OperationalRegion.CENTRAL_EUROPE);
        var usFruc = fructosamine.fromAnalyte("245", OperationalRegion.USA);
        assert usFruc.getAnalyte().equals(clabFruc.getAnalyte());
        assert usFruc.getAnalyte().getAssays().size() == 2;
    }

    @Test
    public void analyteHasAssays() {
        var fructosamine = new Analyte("Fructosamine");
        var clabFruc = fructosamine.fromAnalyte("FRUC", OperationalRegion.CENTRAL_EUROPE);
        var usFruc = fructosamine.fromAnalyte("245", OperationalRegion.USA);
        assert fructosamine.getAssays().size() == 2;
    }
}
