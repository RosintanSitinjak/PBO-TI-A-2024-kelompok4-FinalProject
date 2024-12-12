package service;

public interface EventnPesertaService {
    //EventList[] getEventList();
    void addEvent(String nameEvent, String dateEvent, String eventLocation);
    void tambahPeserta(String nama, String nim, Event1 eventpilih);
    Boolean removeEvent(Integer number);
    Boolean hapusPeserta(Integer number);
    Boolean updateEvent(Integer number, String nameEvent, String dateEvent, String eventLocation);
}
