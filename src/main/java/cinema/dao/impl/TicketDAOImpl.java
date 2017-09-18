package cinema.dao.impl;

import cinema.dao.TicketDAO;
import cinema.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {

    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket event) {
        tickets.add(event);
        return event;
    }

    @Override
    public Ticket get(long id) {
        return tickets.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
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
        Ticket event = get(id);
        tickets.remove(event);

    }
}
