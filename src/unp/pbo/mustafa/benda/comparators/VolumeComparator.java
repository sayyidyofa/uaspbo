package unp.pbo.mustafa.benda.comparators;

import unp.pbo.mustafa.benda.BentukBenda;

import java.util.Comparator;

public class VolumeComparator implements Comparator<BentukBenda> {
    @Override
    public int compare(BentukBenda o1, BentukBenda o2) {
        return Double.compare(o1.getVolume(), o2.getVolume());
    }
}
