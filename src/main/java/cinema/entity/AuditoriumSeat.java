package cinema.entity;

import cinema.entity.enums.SeatType;

public class AuditoriumSeat {
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
                "auditorium=" + auditorium +
                ", number=" + number +
                ", row=" + row +
                ", type=" + type +
                '}';
    }
}
