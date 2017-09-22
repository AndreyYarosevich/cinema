package cinema;

import cinema.dao.AuditoriumSeatDAO;
import cinema.entity.AuditoriumSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Application {


    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("cinema");
        Application app = ctx.getBean(Application.class);

        AuditoriumSeat auditoriumSeat = app.auditoriumSeatDAO.get(1);
        System.out.println(auditoriumSeat);

    }
}
