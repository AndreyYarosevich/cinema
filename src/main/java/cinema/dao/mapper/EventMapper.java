package cinema.dao.mapper;

import cinema.entity.Event;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("id"));
        event.setName(resultSet.getString("name"));
        event.setBasePrice(resultSet.getLong("base_price"));

        Date date = resultSet.getDate("date");
        event.setDate(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));

        return event;
    }
}
