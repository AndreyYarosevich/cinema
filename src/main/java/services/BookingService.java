package services;

import pojo.Event;
import pojo.Ticket;
import pojo.User;

import java.util.Date;
import java.util.List;

public interface BookingService {

    long getTicketsPrice(Event event, Date dateTime, User user, int seats);

    List<Ticket> getPurchasedTicketsForEvent(Event event, Date dateTime);

}
