package cinema.dao.impl;

import cinema.dao.EventDAO;
import cinema.dao.mapper.EventMapper;
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

    @Autowired
    private EventMapper eventMapper;

    private List<Event> events = new ArrayList<>();

    @Override
    public Event save(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event get(long id) {
        String sql = "select * from events where id = ?";

        Event event = jdbcTemplate.queryForObject(sql, new Object[]{id}, eventMapper);

        return event;
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
        String sql = "delete * from events";

    }

    @Override
    public Event getByName(String name) {
        String sql = "select * from events where name = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{name}, eventMapper);
    }

    @Override
    public List<Event> getAll() {
        String sql = "select * from events";
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
