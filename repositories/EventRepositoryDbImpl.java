package repositories;
package repositories.impl;

import entities.Event1;
import repositories.EventRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryDatabaseImpl implements EventRepository {
    private final Connection connection;

    public EventRepositoryDatabaseImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Event1> getAllEvents() {
        List<Event1> events = new ArrayList<>();
        String query = "SELECT * FROM events";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Event1 event = new Event1(
                        resultSet.getString("name_event"),
                        resultSet.getString("date_event"),
                        resultSet.getString("event_location")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public void addEvent(Event1 event) {
        String query = "INSERT INTO events (name_event, date_event, event_location) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getnameEvent());
            statement.setString(2, event.dateEvent);
            statement.setString(3, event.eventLocation);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeEvent(Integer id) {
        String query = "DELETE FROM events WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEvent(Integer id, Event1 event) {
        String query = "UPDATE events SET name_event = ?, date_event = ?, event_location = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getnameEvent());
            statement.setString(2, event.dateEvent);
            statement.setString(3, event.eventLocation);
            statement.setInt(4, id);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Event1 findById(Integer id) {
        String query = "SELECT * FROM events WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Event1(
                        resultSet.getString("name_event"),
                        resultSet.getString("date_event"),
                        resultSet.getString("event_location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
