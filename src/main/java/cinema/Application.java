package cinema;

import cinema.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Application {

    @Autowired
    private EventService eventService;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("cinema");
        Application app = ctx.getBean(Application.class);
        System.out.println();
    }
}
