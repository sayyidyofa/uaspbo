package unp.pbo.mustafa.benda;

import unp.pbo.mustafa.entri.Peserta;

public class Tabung extends BentukBenda {

    public int tinggi;

    public int jarijari;

    public Tabung(Peserta peserta, int tinggi, int jarijari) {
        super(peserta);
        this.tinggi = tinggi;
        this.jarijari = jarijari;
    }

    @Override
    public double getVolume() {
        return Math.PI * jarijari * jarijari * tinggi;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * jarijari * (jarijari + tinggi);
    }
}
