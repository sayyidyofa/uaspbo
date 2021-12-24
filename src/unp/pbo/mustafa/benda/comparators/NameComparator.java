package unp.pbo.mustafa.benda.comparators;

import unp.pbo.mustafa.benda.BentukBenda;

import java.util.Comparator;

public class NameComparator implements Comparator<BentukBenda> {

    @Override
    public int compare(BentukBenda o1, BentukBenda o2) {
        return o1.getPemilikBenda().nama().compareTo(o2.getPemilikBenda().nama());
    }
}
