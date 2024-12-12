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
    public void displayMenu() {
        while (true) {
            System.out.println("====== Menu Event ======");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Show All Event");
            System.out.println("4. Update Event");
            System.out.println("0. Exit");
            System.out.println("========================");
            System.out.print("Enter Your Menu Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEvent();
                case 2 -> removeEvent();
                case 3 -> listAllEvents();
                case 4 -> updateEvent();
                case 0 -> {
                    System.out.println("Thankyou!");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    @Override
    public void addEvent() {
        System.out.print("Nama Event: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Event: ");
        String date = scanner.nextLine();
        System.out.print("Lokasi Event: ");
        String location = scanner.nextLine();
        eventService.addEvent(name, date, location);
    }

    @Override
    public void showPesertaEvent() {

    }

    @Override
    public void run() {

    }
}
