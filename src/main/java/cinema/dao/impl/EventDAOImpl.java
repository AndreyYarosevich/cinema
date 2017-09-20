package cinema.dao.impl;

import cinema.dao.EventDAO;
import cinema.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Event> events = new ArrayList<>();

    @Override
    public Event save(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event get(long id) {
        return events.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event update(Event event) {
        Event currentUser = get(event.getId());
        events.remove(currentUser);
        events.add(event);

        return event;
    }

    @Override
    public void delete(long id) {
        Event event = get(id);
        events.remove(event);

    }

    @Override
    public Event getByName(String name) {
        return events.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Event> getAll() {
        return events;
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
            return events.stream()
                .filter(e -> {
                    long start = from.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long finish = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long current = e.getDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    return current >= start && current <= finish;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime to) {
        return events.stream()
                .filter(e -> {
                    long finish = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long current = e.getDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    return current <= finish;
                }).collect(Collectors.toList());
    }
}
