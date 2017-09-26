package cinema.entity;

import cinema.entity.enums.SeatType;

public class AuditoriumSeat {
    private long id;
    private Auditorium auditorium;
    private int number;
    private int row;
    private SeatType type;

    public AuditoriumSeat() {
    }

    public AuditoriumSeat(Auditorium auditorium, int number, int row, SeatType type) {
        this.auditorium = auditorium;
        this.number = number;
        this.row = row;
        this.type = type;
    }

    public AuditoriumSeat(long id, Auditorium auditorium, int number, int row, SeatType type) {
        this.id = id;
        this.auditorium = auditorium;
        this.number = number;
        this.row = row;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuditoriumSeat{" +
                "id=" + id +
                ", auditorium=" + auditorium +
                ", number=" + number +
                ", row=" + row +
                ", type=" + type +
                '}';
    }
}
