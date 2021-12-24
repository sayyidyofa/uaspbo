package unp.pbo.mustafa;

import unp.pbo.mustafa.benda.*;
import unp.pbo.mustafa.benda.comparators.AreaComparator;
import unp.pbo.mustafa.benda.comparators.NameComparator;
import unp.pbo.mustafa.benda.comparators.VolumeComparator;
import unp.pbo.mustafa.entri.EntriLomba;
import unp.pbo.mustafa.entri.Peserta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuFunctions {

    Scanner scanner;

    public MainMenuFunctions(Scanner scanner) {
        this.scanner = scanner;
    }

    public int landing(EntriLomba entriLomba) throws InputMismatchException {
        if (entriLomba.isEmpty()) {
            System.out.println(
                    """
                    
                    Selamat Datang di lomba Bentuk Benda
                    Belum ada entri lomba terdaftar
                    Apa yang ingin anda lakukan?
                    
                    0) Daftarkan diri anda beserta benda anda
                    4) Keluar
                    """
            );
        } else {
            System.out.println(
                    """
                    
                    Selamat Datang di lomba Bentuk Benda
                    Apa yang ingin anda lakukan?
                    
                    0) Daftarkan diri anda beserta benda anda
                    1) Lihat daftar peserta lomba beserta benda
                    2) Lihat benda dengan volume terbesar
                    3) Lihat benda dengan luas permukaan terbesar
                    4) Keluar
                    """
            );
        }

        return scanner.nextInt();
    }

    public void displayPesertas(EntriLomba entriLomba) {
        entriLomba.sort(new NameComparator());

        final String[] toBePrinted = {"\nPeserta\tTipe\tVolum\tLuasPermukaan\n"};

        entriLomba.forEach(bentukBenda -> {
            toBePrinted[0] = toBePrinted[0] + String.format("%s\t%s\t%.2f\t%.2f\n",
                    bentukBenda.getPemilikBenda().nama(),
                    bentukBenda.getClass().getSimpleName(),
                    bentukBenda.getVolume(),
                    bentukBenda.getArea()
            );
        });

        System.out.println(toBePrinted[0]);
    }

    public void displayVolumestBenda(EntriLomba entriLomba) {
        entriLomba.sort(new VolumeComparator().reversed());

        BentukBenda volumest = entriLomba.get(0);

        System.out.printf("Benda dengan volume terbesar adalah %s yang dimiliki oleh %s dengan nilai volume %f",
                volumest.getClass().getSimpleName(),
                volumest.getPemilikBenda().nama(),
                volumest.getVolume());
    }

    public void displayAreaestBenda(EntriLomba entriLomba) {
        entriLomba.sort(new AreaComparator().reversed());

        BentukBenda areaest = entriLomba.get(0);

        System.out.printf("Benda dengan luas permukaan terbesar adalah %s yang dimiliki oleh %s dengan nilai volume %f",
                areaest.getClass().getSimpleName(),
                areaest.getPemilikBenda().nama(),
                areaest.getVolume());
    }

    public String inputNamaPemilik() throws Exception {
        System.out.print("Register nama pemilik benda: ");

        String nama = scanner.next();

        if (nama.length() < 1) {
            throw new Exception();
        }

        return nama;
    }

    public int inputTipeBenda() throws InputMismatchException {
        System.out.println("Berikut tipe benda yang bisa dilombakan:");

        System.out.println("1) Kubus\t2) Tabung\n3) Kerucut\t4) Bola");

        System.out.print("Pilih salah satu tipe benda [1-4]: ");

        return scanner.nextInt();
    }

    public BentukBenda inputDataBenda(int tipeBenda, Peserta pemilikBenda) throws Exception {

        return switch (tipeBenda) {
            case 1 -> // Kubus
                    inputDataKubus(pemilikBenda);
            case 2 -> // Tabung
                    inputDataTabung(pemilikBenda);
            case 3 -> // Kerucut
                    inputDataKerucut(pemilikBenda);
            case 4 -> // Bola
                    inputDataBola(pemilikBenda);
            default -> throw new Exception();
        };
    }

    private Kubus inputDataKubus(Peserta pemilikBenda) throws InputMismatchException {

        Kubus kubus;

        System.out.print("Panjang sisi kubus : ");

        int sisi = scanner.nextInt();

        kubus = new Kubus(pemilikBenda, sisi);

        return kubus;
    }

    private Tabung inputDataTabung(Peserta pemilikBenda) throws InputMismatchException {

        Tabung tabung;

        System.out.print("Panjang jari-jari tabung: ");

        int jarijari = scanner.nextInt();

        System.out.print("Tinggi tabung: ");

        int tinggi = scanner.nextInt();

        tabung = new Tabung(pemilikBenda, tinggi, jarijari);

        return tabung;
    }

    private Kerucut inputDataKerucut(Peserta pemilikBenda) {

        Kerucut kerucut;

        System.out.print("Panjang jari-jari kerucut: ");

        int jarijari = scanner.nextInt();

        System.out.print("Tinggi kerucut: ");

        int tinggi = scanner.nextInt();

        kerucut = new Kerucut(pemilikBenda, tinggi, jarijari);

        return kerucut;
    }

    private Bola inputDataBola(Peserta pemilikBenda) {

        Bola bola;

        System.out.print("Panjang jari-jari bola: ");

        int jarijari = scanner.nextInt();

        bola = new Bola(pemilikBenda, jarijari);

        return bola;
    }
}
