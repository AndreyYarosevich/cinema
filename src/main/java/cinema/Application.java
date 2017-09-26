package cinema;

import cinema.dao.AuditoriumDAO;
import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.EventDAO;
import cinema.entity.Auditorium;
import cinema.entity.AuditoriumSeat;
import cinema.entity.Event;
import cinema.entity.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class Application {


    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Autowired
    private EventDAO eventDAO;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("cinema");
        Application app = ctx.getBean(Application.class);

        Auditorium auditorium = app.auditoriumDAO.get(2);
        AuditoriumSeat auditoriumSeat = app.auditoriumSeatDAO.save(new AuditoriumSeat(auditorium, 12, 15, SeatType.STANDART));
        System.out.println(auditoriumSeat);

        Event event1 = new Event( "andrey", 500, LocalDateTime.now());
        Event event = app.eventDAO.save(event1);
        System.out.println(event);
    }
}
