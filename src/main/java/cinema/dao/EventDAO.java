package cinema.dao;

import cinema.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDAO {

    Event save(Event event);

    Event get(long id);

    Event update(Event event);

    void delete(long id);

    Event getByName(String name);

    List<Event> getAll();

    List<Event> getForDateRange(LocalDateTime from, LocalDateTime to);

    List<Event> getNextEvents(LocalDateTime to);
}
