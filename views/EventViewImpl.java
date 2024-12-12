package views;

import services.EventService;

//nunggu selesai entities sama services

import java.util.Scanner;

public class EventViewImpl implements EventView{
    private final EventService eventService;
    private final Scanner scanner = new Scanner(System.in);

    public EventViewImpl(EventService eventService){
        this.eventService = eventService;
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
