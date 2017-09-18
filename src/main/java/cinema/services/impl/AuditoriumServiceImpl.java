package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.entity.Auditorium;
import cinema.services.AuditoriumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
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
