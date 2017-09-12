package cinema.services;

import cinema.pojo.Auditorium;

import java.util.List;

public interface AuditoriumService {

    List<Auditorium> getAll();

    Auditorium getByName(String name);
}
