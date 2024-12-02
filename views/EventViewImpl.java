package views;

//import services.EventService;
//import services.PesertaService;
import entities.Event1;
import entities.Event2;
//nunggu selesai entities sama services

import java.util.List;
import java.util.Scanner;

public class EventViewImpl implements EventView{
//    private final EventService eventService;
//    private final PesertaService pesertaService;
    private static Scanner scanner = new Scanner(System.in);

//    public EventViewImpl(EventService eventService, PesertaService pesertaService){
//        this.eventService = eventService;
//        this.pesertaService = pesertaService;
//    }

    public String input(String info){
        System.out.println(info + " : ");
        return scanner.nextLine();

    }

    @Override
    public void showMainMenu() {
        System.out.println("Alhamdullilah bisa nge push juga");

    }

    @Override
    public void showEventMenu() {

    }

    @Override
    public void showPesertaEvent() {

    }

    @Override
    public void run() {

    }
}
