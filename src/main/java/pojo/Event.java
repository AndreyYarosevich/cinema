package pojo;

import enums.Rating;

import java.util.Date;

public class Event {
    private long id;
    private String name;
    private long basePriceForTickets;
    private Rating rating;
    private Date date;

    public Event(long id, String name, long basePriceForTickets, Rating rating, Date date) {
        this.id = id;
        this.name = name;
        this.basePriceForTickets = basePriceForTickets;
        this.rating = rating;
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

    public long getBasePriceForTickets() {
        return basePriceForTickets;
    }

    public void setBasePriceForTickets(long basePriceForTickets) {
        this.basePriceForTickets = basePriceForTickets;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePriceForTickets=" + basePriceForTickets +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}

