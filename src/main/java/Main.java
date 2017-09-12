import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cinema.pojo.Event;
import cinema.services.EventService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        EventService eventService = ctx.getBean("eventService", EventService.class);
        eventService.save(new Event(1, "film",500, LocalDateTime.now()));
        eventService.getAll();




    }
}
