package cinema.dao;

import cinema.entity.Ticket;

public interface TicketDAO {

    Ticket save(Ticket event);

    Ticket get(long id);

    Ticket update(Ticket event);

    void delete(long id);
}
