package entities;

import java.util.ArrayList;
import java.util.Scanner;

import static entities.Event2.events;

public class Peserta {
    static ArrayList<PesertaInfo> pesertaList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void tambahPeserta() {
        System.out.println("Silahkan Masukkan Detail Peserta:");
        System.out.println("-------------------------------------");

        System.out.print("Nama Peserta: ");
        String nama = input.nextLine();

        System.out.print("NIM Peserta: ");
        String nim = input.nextLine();

        if (events.isEmpty()) {
            System.out.println("Belum ada event yang tersedia...");
        }

        System.out.println("DAFTAR EVENT");
        for (int i = 0; i < events.size(); i++) {
            Event1 event = events.get(i);

            System.out.println("_________________________________");
            System.out.println((i + 1) + ". Nama Event: " + event.nameEvent);
            System.out.println("_________________________________");
        }
        System.out.print("Event yang Diikuti (nomor): ");
        int eventchoice = input.nextInt() - 1;
        input.nextLine();

        if (eventchoice >= 0 && eventchoice < events.size()) {
            Event1 event = events.get(eventchoice);
            PesertaInfo peserta = new PesertaInfo(nama, nim, event);
            pesertaList.add(peserta);
            event.tambahPeserta(peserta);
            System.out.println("Peserta berhasil ditambahkan!");
            System.out.println("-------------------------------------");
        } else {
            System.out.println("Event tidak ditemukan");
        }

        System.out.print("Ingin Kembali ke Menu Peserta? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuPeserta();
        }
    }

    public static void lihatPeserta() {
        if (pesertaList.isEmpty()) {
            System.out.println("Tidak Ada Peserta yang Terdaftar!");
            menuPeserta();
        }

        System.out.println("Daftar Peserta yang Sudah Terdaftar:");
        System.out.println("--------------------------------------");
        for (int i = 0; i < pesertaList.size(); i++) {
            PesertaInfo peserta = pesertaList.get(i);
            System.out.println((i + 1) + ". Nama: " + peserta.nama);
        }

        System.out.print("Ingin Kembali ke Menu Peserta? (y/n): ");
        String back = input.nextLine();

        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuPeserta();
        }
    }


    public static void hapusPeserta() {
        System.out.println("Daftar Peserta yang Sudah Terdaftar:");
        System.out.println("--------------------------------------");
        for (int i = 0; i < pesertaList.size(); i++) {
            PesertaInfo peserta = pesertaList.get(i);
            System.out.println((i + 1) + ". Nama: " + peserta.nama);
            System.out.println("   NIM: " + peserta.nim);
            System.out.println("   Event: " + peserta.eventpilih.getnameEvent());
        }

        System.out.println("--------------------------------------");
        System.out.print("Masukkan nama Peserta yang Ingin Dihapus: ");
        String nama = input.nextLine();

        PesertaInfo pesertaRemove = null;
        for(PesertaInfo peserta : pesertaList){
            if (peserta.getnamaPeserta().equalsIgnoreCase(String.valueOf(nama))){
                pesertaRemove = peserta;
                break;
            }
        }

        if (pesertaRemove != null){
            pesertaList.remove(pesertaRemove);
            pesertaRemove.getEvent().hapusPeserta(pesertaRemove);
            System.out.println("Peserta Telah Berhasil Dihapus!");
        } else {
            System.out.println("Peserta tidak ditemukan");
        }


        System.out.print("Ingin Kembali ke Menu Peserta? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuPeserta();
        } else {
            return;
        }
    }

    public static void lihatTotalPeserta() {
        if (events.isEmpty()) {
            System.out.println("Belum ada event yang tersedia");
            menuPeserta();
        }
        for (Event1 event : events) {
            System.out.println("Nama Event: " + event.getnameEvent() + ",Total Peserta: " + event.getPesertaList().size());
        }

        System.out.print("Ingin Kembali ke Menu Utama? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            Main.utama();
        } else {
            return;
        }
    }

    public static void lihatDetailPeserta(){
        System.out.println("Masukkan nama peserta: ");
        String nama = input.nextLine();

        boolean found = false;
        for(PesertaInfo peserta : pesertaList){
            if (peserta.getnamaPeserta().equalsIgnoreCase(nama)){
                peserta.tampilDetailPeserta();
                found = true;
            }
        }
        System.out.print("Ingin Kembali ke Menu Utama? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            Main.utama();
        } else {
            return;
        }

        if (!found){
            System.out.println("Peserta tidak terdaftar");
        }
    }


    public static void menuPeserta() {
        System.out.println("====== Menu Peserta ======");
        System.out.println("1. Lihat Peserta");
        System.out.println("2. Tambah Peserta");
        System.out.println("3. Hapus Peserta");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.println("==========================");
        System.out.print("Masukkan Pilihan Menu: ");
        int choose = input.nextInt();
        input.nextLine();

        switch (choose) {
            case 1:
                Main.clearScreen();
                lihatPeserta();
                break;
            case 2:
                Main.clearScreen();
                tambahPeserta();
                break;
            case 3:
                Main.clearScreen();
                hapusPeserta();
                break;
            case 0:
                Main.clearScreen();
                Main.utama();
                break;
            default:
                System.out.println("Pilihan Menu Tidak Valid");
        }
    }
}