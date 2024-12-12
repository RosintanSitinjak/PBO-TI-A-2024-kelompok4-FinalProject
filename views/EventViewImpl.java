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
    public void removeEvent() {
        System.out.print("Masukkan Index Event untuk dihapus: ");
        String name = scanner.nextLine();
        eventService.removeEvent(name);
//        int index = scanner.nextInt();
//        scanner.nextLine();
//        eventService.removeEvent(index - 1);
    }

    @Override
    public void updateEvent(){
        System.out.print("Nama Event yang akan diupdate: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Event Baru: ");
        String date = scanner.nextLine();
        System.out.print("Lokasi Event Baru: ");
        String location = scanner.nextLine();
        eventService.updateEvent(name, date, location);
    }

    @Override
    public void listAllEvents() {
        eventService.getAllEvents().forEach(event -> {
            System.out.println("Nama Event: " + event.getNameEvent());
            System.out.println("Tanggal: " + event.getDateEvent());
            System.out.println("Lokasi: " + event.getEventLocation());
        });
    }
}
