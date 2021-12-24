package unp.pbo.mustafa.entri;

import unp.pbo.mustafa.benda.BentukBenda;
import unp.pbo.mustafa.benda.comparators.AreaComparator;
import unp.pbo.mustafa.benda.comparators.VolumeComparator;

import java.util.ArrayList;

public class EntriLomba extends ArrayList<BentukBenda> {
    public void sortByVolume() {
        this.sort(new VolumeComparator());
    }

    public void sortByArea() {
        this.sort(new AreaComparator());
    }
}
