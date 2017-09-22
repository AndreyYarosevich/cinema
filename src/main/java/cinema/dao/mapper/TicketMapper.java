package cinema.dao.mapper;

import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.EventDAO;
import cinema.dao.UserDAO;
import cinema.entity.AuditoriumSeat;
import cinema.entity.Event;
import cinema.entity.Ticket;
import cinema.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketMapper implements RowMapper<Ticket> {

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(resultSet.getLong("id"));

        long userId = resultSet.getLong("user_id");
        User user = userDAO.get(userId);
        ticket.setUser(user);

        long eventId = resultSet.getLong("event_id");
        Event event = eventDAO.get(eventId);
        ticket.setEvent(event);

        ticket.setDateTime(resultSet.getTime("date_time"));

        long seatId = resultSet.getLong("seat_id");
        AuditoriumSeat auditoriumSeat = auditoriumSeatDAO.get(seatId);
        ticket.setSeat(auditoriumSeat);

        return ticket;
    }
}
