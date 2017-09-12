package cinema.pojo;

import java.util.List;

public class Auditorium {
    private String name;
    private List<AuditoriumSeat> seats;

    public Auditorium(String name, List<AuditoriumSeat> seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuditoriumSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<AuditoriumSeat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}

