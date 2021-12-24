package unp.pbo.mustafa.benda;

import unp.pbo.mustafa.entri.Peserta;

public class Kubus extends BentukBenda {

    public int sisi;

    public Kubus(Peserta peserta, int sisi) {
        super(peserta);
        this.sisi = sisi;
    }

    @Override
    public double getVolume() {
        return sisi * sisi * sisi;
    }

    @Override
    public double getArea() {
        return 6 * sisi * sisi;
    }
}
