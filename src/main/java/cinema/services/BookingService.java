package cinema.services;

import cinema.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    long getTicketsPrice(Event event, LocalDateTime dateTime, User user, AuditoriumSeat seats);

    List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);

}
