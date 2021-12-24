package unp.pbo.mustafa.benda;

import unp.pbo.mustafa.entri.Peserta;

public class Kerucut extends BentukBenda{

    public int tinggi;

    public int jarijari;

    public Kerucut(Peserta peserta, int tinggi, int jarijari) {
        super(peserta);
        this.tinggi = tinggi;
        this.jarijari = jarijari;
    }

    @Override
    public double getVolume() {
        return 1.0 / 3.0 * Math.PI * jarijari * jarijari * tinggi;
    }

    @Override
    public double getArea() {
        return Math.PI * jarijari * (jarijari + getApothem());
    }

    private double getApothem() {
        return Math.sqrt(jarijari*jarijari + tinggi*tinggi);
    }
}
