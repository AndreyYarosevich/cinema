package cinema.dao.impl;

import cinema.dao.EventDAO;
import cinema.dao.mapper.EventMapper;
import cinema.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EventMapper eventMapper;


    @Override
    public Event save(Event event) {
        String sql = "INSERT INTO events (name, base_price, date) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getName());
            preparedStatement.setLong(2, event.getBasePrice());
            preparedStatement.setDate(3, Date.valueOf(event.getDate().toLocalDate()));

            return preparedStatement;
        }, keyHolder);

        long id = (long) keyHolder.getKeyList().get(0).get("id");
        event.setId(id);

        return event;
    }

    @Override
    public Event get(long id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        Event event = jdbcTemplate.queryForObject(sql, eventMapper, id);

        return event;
    }

    @Override
    public Event update(Event event) {
        String sql = "update events SET name = ?, base_price = ?, date = ? where id = ?";
        jdbcTemplate.update(sql, event.getName(), event.getBasePrice(), event.getDate());

        return event;
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM events WHERE id = ?";
        jdbcTemplate.update(sql, eventMapper, id);
    }

    @Override
    public Event getByName(String name) {
        String sql = "SELECT * FROM events WHERE name = ?";

        return jdbcTemplate.queryForObject(sql, eventMapper, name);
    }

    @Override
    public List<Event> getAll() {
        String sql = "SELECT * FROM events";
        return jdbcTemplate.query(sql, eventMapper);
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        String sql = "SELECT * FROM events WHERE  date BETWEEN ? AND ?";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.S");

        return jdbcTemplate.query(sql, eventMapper, format.format(from), format.format(to));
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime to) {
        String sql = "SELECT * FROM events WHERE  date BETWEEN ? AND (SELECT MAX(date) FROM events)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.S");

        return jdbcTemplate.query(sql, eventMapper, format.format(to));
    }
}
