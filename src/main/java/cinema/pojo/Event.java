package cinema.pojo;

import java.time.LocalDateTime;

public class Event {
    private long id;
    private String name;
    private long basePrice;
    private LocalDateTime date;

    public Event() {

    }

    public Event(long id, String name, long basePrice, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.date = date;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", date=" + date +
                '}';
    }
}

