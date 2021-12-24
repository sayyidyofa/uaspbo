package unp.pbo.mustafa.benda;

import unp.pbo.mustafa.entri.Peserta;

public class Bola extends BentukBenda {

    public int jarijari;

    public Bola(Peserta peserta, int jarijari) {
        super(peserta);
        this.jarijari = jarijari;
    }

    @Override
    public double getVolume() {
        return 4.0/3.0 * Math.PI * jarijari * jarijari * jarijari;
    }

    @Override
    public double getArea() {
        return 4.0 * Math.PI * jarijari * jarijari;
    }
}
