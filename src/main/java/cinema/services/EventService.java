package cinema.services;

import cinema.pojo.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    void save(Event event);

    void remove(Event event);

    Event getById(long id);

    Event getByName(String name);

    List<Event> getAll();

    List<Event> getForDateRange(LocalDateTime from, LocalDateTime to);

    List<Event> getNextEvents(LocalDateTime to);
}
