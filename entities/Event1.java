package entities;


import java.util.ArrayList;
import static entities.Peserta.pesertaList;

public class Event1{
    String nameEvent;
    String dateEvent;
    String eventLocation;
    ArrayList<PesertaInfo> pesertaList = new ArrayList<>();


    public Event1(String nameEvent, String dateEvent, String eventLocation){
        this.nameEvent = nameEvent;
        this.dateEvent = dateEvent;
        this.eventLocation = eventLocation;
    }


    public String getnameEvent() {
        return nameEvent;
    }
    public void tambahPeserta(PesertaInfo peserta){
        pesertaList.add(peserta);
    }
    public void hapusPeserta(PesertaInfo peserta){
        pesertaList.remove(peserta);
    }
    public ArrayList<PesertaInfo> getPesertaList() {
        return pesertaList;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public String getEventLocation() {
        return eventLocation;
    }
}
