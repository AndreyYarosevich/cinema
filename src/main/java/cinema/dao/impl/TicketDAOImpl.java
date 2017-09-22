package cinema.dao.impl;

import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.EventDAO;
import cinema.dao.TicketDAO;
import cinema.dao.UserDAO;
import cinema.dao.mapper.TicketMapper;
import cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public Ticket get(long id) {
        String sql = "select * from tickets where id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, ticketMapper);
    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket currentUser = get(ticket.getId());
        tickets.remove(currentUser);
        tickets.add(ticket);

        return ticket;
    }

    @Override
    public void delete(long id) {
        String sql = "delete * from tickets where id = ?";


    }
}
