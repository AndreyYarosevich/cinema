package cinema.dao;

import cinema.entity.AuditoriumSeat;

public interface AuditoriumSeatDAO {

    AuditoriumSeat save(AuditoriumSeat auditorium);

    AuditoriumSeat get(long id);

    AuditoriumSeat update(AuditoriumSeat auditorium);

    void delete(long id);
}
