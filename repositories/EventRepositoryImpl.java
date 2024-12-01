package repositories;

package repositories.impl;

import entities.Event1;
import repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {
    private final List<Event1> events = new ArrayList<>();

    @Override
    public List<Event1> getAllEvents() {
        return new ArrayList<>(events);
    }

    @Override
    public void addEvent(Event1 event) {
        events.add(event);
    }

    @Override
    public boolean removeEvent(Integer id) {
        if (id < 0 || id >= events.size()) {
            return false;
        }
        events.remove((int) id);
        return true;
    }

    @Override
    public boolean updateEvent(Integer id, Event1 updatedEvent) {
        if (id < 0 || id >= events.size()) {
            return false;
        }
        events.set(id, updatedEvent);
        return true;
    }

    @Override
    public Event1 findById(Integer id) {
        if (id < 0 || id >= events.size()) {
            return null;
        }
        return events.get(id);
    }
}
