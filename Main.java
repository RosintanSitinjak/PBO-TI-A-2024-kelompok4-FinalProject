package com.eventmanagement;

import com.eventmanagement.repositories.EventRepository;
import com.eventmanagement.repositories.ParticipantRepository;
import com.eventmanagement.services.EventService;
import com.eventmanagement.services.ParticipantService;
import com.eventmanagement.views.MainView;

public class Main {
    public static void main(String[] args) {
        EventRepository eventRepository = new EventRepository();
        ParticipantRepository participantRepository = new ParticipantRepository();
        EventService eventService = new EventService(eventRepository, participantRepository);
        ParticipantService participantService = new ParticipantService(participantRepository, eventRepository);
        MainView mainView = new MainView(eventService, participantService);
        mainView.utama();
    }
}