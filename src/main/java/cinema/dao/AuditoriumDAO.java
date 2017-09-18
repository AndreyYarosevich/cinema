package cinema.dao;

import cinema.entity.Auditorium;

import java.util.List;

public interface AuditoriumDAO {

    Auditorium save(Auditorium auditorium);

    Auditorium get(long id);

    Auditorium update(Auditorium auditorium);

    void delete(long id);

    List<Auditorium> getAll();

    Auditorium getByName(String name);

}
