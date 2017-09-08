package servicesImpl;

import pojo.Event;
import pojo.Ticket;
import pojo.User;
import services.BookingService;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public long getTicketsPrice(Event event, Date dateTime, User user, int seats) {
        return 0;
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, Date dateTime) {
        return null;
    }
}
