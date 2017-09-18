package cinema;


import cinema.entity.Auditorium;
import cinema.entity.Event;
import cinema.entity.Ticket;
import cinema.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemmoryDataBaseSimulator {

    public static List<User> users = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Auditorium> auditoriums = new ArrayList<>();
    public static List<Ticket> tickets = new ArrayList<>();


}
