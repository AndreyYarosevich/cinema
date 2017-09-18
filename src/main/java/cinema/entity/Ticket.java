package cinema.entity;

import java.time.LocalDateTime;


public class Ticket {
    private long id;
    private User user;
    private Event event;
    private LocalDateTime dateTime;
    private AuditoriumSeat seat;

    public Ticket() {
    }

    public Ticket(long id, User user, Event event, LocalDateTime dateTime, AuditoriumSeat seat) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public AuditoriumSeat getSeat() {
        return seat;
    }

    public void setSeat(AuditoriumSeat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                '}';
    }
}
