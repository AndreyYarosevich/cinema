package cinema;

import cinema.dao.AuditoriumDAO;
import cinema.dao.AuditoriumSeatDAO;
import cinema.entity.Auditorium;
import cinema.entity.AuditoriumSeat;
import cinema.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Application {

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("cinema");
        Application app = ctx.getBean(Application.class);

        AuditoriumSeat auditoriumSeat = app.auditoriumSeatDAO.get(1);
        System.out.println(auditoriumSeat);

    }
}
