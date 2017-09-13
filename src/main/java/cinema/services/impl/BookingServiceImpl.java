package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.pojo.*;
import cinema.services.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class BookingServiceImpl implements BookingService {

    @Override
    public long getTicketsPrice(Event event, LocalDateTime dateTime, User user, AuditoriumSeat seats) {
       return InMemmoryDataBaseSimulator.tickets.stream()
               .filter(t ->
                       t.getEvent().equals(event) &&
                       t.getDateTime().equals(dateTime) &&
                       t.getUser().equals(user) &&
                       t.getSeat().equals(seats))
               .map(Ticket::getEvent)
               .mapToLong(Event::getBasePrice)
               .sum();
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return InMemmoryDataBaseSimulator.tickets.stream()
                .filter(t -> t.getEvent().equals(event) && t.getDateTime().equals(dateTime))
                .collect(Collectors.toList());
    }
}
