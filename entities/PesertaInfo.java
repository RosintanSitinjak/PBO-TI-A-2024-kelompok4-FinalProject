package entities;

public class PesertaInfo {
    String nama;
    String nim;
    Event1 eventpilih;

    public PesertaInfo(String nama, String nim, Event1 eventpilih) {
        this.nama = nama;
        this.nim = nim;
        this.eventpilih = eventpilih;
    }

    public String getnamaPeserta(){
        return nama;
    }

    public String getnimPeserta(){
        return nim;
    }

    public Event1 getEvent(){
        return eventpilih;
    }

    public void tampilDetailPeserta(){
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Event diikuti: " + eventpilih.getnameEvent());
    }
}