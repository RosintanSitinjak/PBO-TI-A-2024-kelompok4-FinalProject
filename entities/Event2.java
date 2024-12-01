package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Event2 {
    static ArrayList<Event1> events = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void addEvent() {
        System.out.println("Silahkan Masukkan Detail Event");
        System.out.println("-------------------------------------");
        System.out.print("Nama Event: ");
        String nameEvent = input.nextLine();

        System.out.print("Tanggal Event: ");
        String dateEvent = input.nextLine();

        System.out.print("Tempat/Lokasi Event: ");
        String eventLocation = input.nextLine();

        System.out.println("-------------------------------------");
        Event1 newEvent = new Event1(nameEvent, dateEvent, eventLocation);
        events.add(newEvent);
        System.out.println("Event Telah Berhasil Ditambahkan!");
        System.out.println("-------------------------------------");

        System.out.print("Ingin Kembali ke Menu Awal? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuEvent();
        }
    }

    public static void removeEvent() {
        if (events.isEmpty()) {
            System.out.println("Tidak Ada Event yang Terdaftar!");
            return;
        }

        System.out.println("Daftar Event yang Sudah Terdaftar: ");
        System.out.println("===================================");
        for (int i = 0; i < events.size(); i++) {
            Event1 event = events.get(i);
            System.out.println((i + 1) + ". Nama Event: " + event.nameEvent);
            System.out.println("   Tanggal Event: " + event.dateEvent);
            System.out.println("   Tempat/Lokasi Event: " + event.eventLocation);
            System.out.println("___________________________________");
        }

        System.out.println("=======================================");
        System.out.print("Masukkan Nomor Event yang Ingin Dihapus: ");
        int delete = input.nextInt();
        input.nextLine();

        if (delete <= 0 || delete > events.size()) {
            System.out.println("Nomor Event yang Anda Masukkan Tidak Valid");
            return;
        }

        events.remove(delete - 1);
        System.out.println("================================");
        System.out.println("Event Telah Berhasil Dihapus!");

        System.out.print("Ingin Kembali ke Menu Awal? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuEvent();
        }
    }

    public static void updateEvent() {
        if (events.isEmpty()) {
            System.out.println("Tidak Ada Event yang Terdaftar!");
            return;
        }

        System.out.println("Daftar Event yang Sudah Terdaftar: ");
        System.out.println("-------------------------------------");

        for (int i = 0; i < events.size(); i++) {
            Event1 event = events.get(i);
            System.out.println((i + 1) + ". Nama Event: " + event.nameEvent);
            System.out.println("   Tanggal Event: " + event.dateEvent);
            System.out.println("   Tempat/Lokasi Event: " + event.eventLocation);
        }

        System.out.println("----------------------------------------");
        System.out.print("Masukkan Nomor Event yang Ingin Diedit: ");
        int update = input.nextInt();
        input.nextLine();

        if (update <= 0 || update > events.size()) {
            System.out.println("Nomor Event Tidak Valid");
            return;
        }

        Event1 event = events.get(update - 1);

        System.out.println("----------------------------------------");
        System.out.println("Silahkan Edit Detail Event: \n");

        System.out.print("Nama Event: ");
        event.nameEvent = input.nextLine();

        System.out.print("Tanggal Event: ");
        event.dateEvent = input.nextLine();

        System.out.print("Tempat/Lokasi Event: ");
        event.eventLocation = input.nextLine();

        System.out.println("-----------------------------");
        System.out.println("Event Telah Berhasil Diupdate!");

        System.out.print("Ingin Kembali ke Menu Awal? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuEvent();
        }
    }

    public static void showEvent() {
        if (events.isEmpty()) {
            System.out.println("Tidak Ada Event yang Terdaftar!");
            return;
        }

        System.out.println("Daftar Event yang Sudah Terdaftar");
        System.out.println("_________________________________");
        for (int i = 0; i < events.size(); i++) {
            Event1 event = events.get(i);
            System.out.println((i + 1) + ". Nama Event: " + event.nameEvent);
            System.out.println("   Tanggal Event: " + event.dateEvent);
            System.out.println("   Tempat/Lokasi Event: " + event.eventLocation);
            System.out.println("-----------------------------------");
        }

        System.out.print("Ingin Kembali ke Menu Awal? (y/n): ");
        String back = input.nextLine();
        if (back.equalsIgnoreCase("y")) {
            Main.clearScreen();
            menuEvent();
        }
    }

    // Method untuk mencari event berdasarkan nama
    public static void searchEvent() {
        if (events.isEmpty()) {
            System.out.println("Tidak Ada Event yang Terdaftar!");
            return;
        }

        System.out.print("Masukkan Kata Kunci untuk Mencari Event: ");
        String keyword = input.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("Hasil Pencarian:");
        System.out.println("----------------------------");

        for (Event1 event : events) {
            if (event.nameEvent.toLowerCase().contains(keyword)) {
                System.out.println("Nama Event: " + event.nameEvent);
                System.out.println("Tanggal: " + event.dateEvent);
                System.out.println("Lokasi: " + event.eventLocation);
                System.out.println("----------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Event Tidak Ditemukan!");
        }
    }

    public static void menuEvent() {
        System.out.println("====== Menu Event ======");
        System.out.println("1. Tambah Event");
        System.out.println("2. Hapus Event");
        System.out.println("3. Edit Event");
        System.out.println("4. Lihat Semua Event");
        System.out.println("5. Cari Event Berdasarkan Nama");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.println("========================");
        System.out.print("Masukkan Pilihan Menu: ");
        int choose = input.nextInt();
        input.nextLine();

        switch (choose) {
            case 1:
                Main.clearScreen();
                addEvent();
                break;
            case 2:
                Main.clearScreen();
                removeEvent();
                break;
            case 3:
                Main.clearScreen();
                updateEvent();
                break;
            case 4:
                Main.clearScreen();
                showEvent();
                break;
            case 5:
                Main.clearScreen();
                searchEvent();
                break;
            case 0:
                Main.clearScreen();
                Main.utama();
                break;
            default:
                System.out.println("Pilihan Menu Tidak Valid, Silahkan Masukkan Pilihan Menu Kembali");
        }
    }
}
