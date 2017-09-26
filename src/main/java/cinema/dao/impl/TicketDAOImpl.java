package cinema.dao.impl;

import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.EventDAO;
import cinema.dao.TicketDAO;
import cinema.dao.UserDAO;
import cinema.dao.mapper.TicketMapper;
import cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Ticket save(Ticket ticket) {
        String sql = "INSERT INTO tickets (user_id, event_id, date_time, seat_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, ticket.getUser().getId());
            preparedStatement.setLong(2, ticket.getEvent().getId());
            preparedStatement.setDate(3, Date.valueOf(ticket.getDateTime().toLocalDate()));
            preparedStatement.setLong(4, ticket.getSeat().getId());

            return preparedStatement;
        }, keyHolder);

        long id = (long) keyHolder.getKeyList().get(0).get("id");
        ticket.setId(id);

        return ticket;
    }

    @Override
    public Ticket get(long id) {
        String sql = "select * from tickets where id = ?";

        return jdbcTemplate.queryForObject(sql, ticketMapper, id);
    }

    @Override
    public Ticket update(Ticket ticket) {
        String sql = "update tickets set user_id = ?, event_id = ?, date_time = ?, seat_id = ? where id = ?";
        jdbcTemplate.update(sql, ticket.getUser().getId(), ticket.getEvent().getId(), ticket.getDateTime(), ticket.getSeat().getId());

        return ticket;
    }

    @Override
    public void delete(long id) {
        String sql = "delete from tickets where id = ?";
        jdbcTemplate.update(sql, ticketMapper, id);
    }
}
