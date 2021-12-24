package unp.pbo.mustafa.benda;

import unp.pbo.mustafa.entri.Peserta;

public abstract class BentukBenda {

    Peserta pemilikBenda;

    public BentukBenda(Peserta peserta) {
        pemilikBenda = peserta;
    }

    public Peserta getPemilikBenda() {
        return pemilikBenda;
    }

    public abstract double getVolume();

    public abstract double getArea();

}
