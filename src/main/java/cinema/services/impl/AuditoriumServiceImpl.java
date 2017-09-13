package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.pojo.Auditorium;
import cinema.services.AuditoriumService;

import java.util.List;
import java.util.Optional;

public class AuditoriumServiceImpl implements AuditoriumService {
    @Override
    public List<Auditorium> getAll() {

        return InMemmoryDataBaseSimulator.auditoriums;
    }

    @Override
    public Auditorium getByName(String name) {

        Optional<Auditorium> auditoriumOptional = InMemmoryDataBaseSimulator.auditoriums.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();

        return auditoriumOptional.orElse(new Auditorium());
    }
}
