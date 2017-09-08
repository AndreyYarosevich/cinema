package services;

import pojo.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    void save(Event event);

    void remove(Event event);

    Event getById(long id);

    Event getByName(String name);

    List<Event> getAll();

    Event getForDateRange(Date from, Date to);

    Event getNextEvents(Date to);
}
