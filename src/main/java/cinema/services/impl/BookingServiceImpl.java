package cinema.services.impl;

import cinema.pojo.Event;
import cinema.pojo.Ticket;
import cinema.pojo.User;
import cinema.services.BookingService;

import java.time.LocalDateTime;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Override
    public long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats) {
        return 0;
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return null;
    }
}
