package cinema.entity;

import java.util.List;

public class Auditorium {
    private long id;
    private String name;
    private List<AuditoriumSeat> seats;

    public Auditorium() {

    }

    public Auditorium(long id, String name, List<AuditoriumSeat> seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
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

    public List<AuditoriumSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<AuditoriumSeat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return seats != null ? seats.equals(that.seats) : that.seats == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seats != null ? seats.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
