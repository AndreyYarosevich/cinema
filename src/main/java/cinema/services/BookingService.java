package cinema.services;

import cinema.pojo.Event;
import cinema.pojo.Ticket;
import cinema.pojo.User;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats);

    List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);

}
