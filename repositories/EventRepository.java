package repositories;

import entities.Event1;

import java.util.List;

public interface EventRepository {
    List<Event1> getAllEvents();

    void addEvent(Event1 event);

    boolean removeEvent(Integer id);

    boolean updateEvent(Integer id, Event1 event);

    Event1 findById(Integer id);
}