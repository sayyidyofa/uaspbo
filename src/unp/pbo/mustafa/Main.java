package unp.pbo.mustafa;

import unp.pbo.mustafa.benda.BentukBenda;
import unp.pbo.mustafa.entri.EntriLomba;
import unp.pbo.mustafa.entri.Peserta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EntriLomba entriLomba = new EntriLomba();

        Scanner keyboard = new Scanner(System.in);

        MainMenuFunctions mainMenuFunctions = new MainMenuFunctions(keyboard);

        int pilihan;

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                pilihan = mainMenuFunctions.landing(entriLomba);
                if (pilihan < 0 || pilihan > 4) {
                    System.out.println("Pilihan invalid!");
                } else {
                    if (pilihan == 4) break;
                    if (entriLomba.isEmpty() && pilihan != 0) System.out.println("Pilihan invalid!");
                    else {
                        switch (pilihan) {
                            case 0 -> {
                                Peserta peserta;
                                int tipeBenda;
                                BentukBenda benda;
                                try {
                                    String nama = mainMenuFunctions.inputNamaPemilik();
                                    peserta = new Peserta(nama);
                                    tipeBenda = mainMenuFunctions.inputTipeBenda();
                                    benda = mainMenuFunctions.inputDataBenda(tipeBenda, peserta);
                                    entriLomba.add(benda);
                                } catch (Exception e) {
                                    System.out.printf("\nData invalid! %s\n", e.getClass().getName());
                                }
                            }
                            case 1 -> mainMenuFunctions.displayPesertas(entriLomba);
                            case 2 -> mainMenuFunctions.displayVolumestBenda(entriLomba);
                            case 3 -> mainMenuFunctions.displayAreaestBenda(entriLomba);
                            default -> {}
                        }
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid number! ");
            }
        }
    }
}
