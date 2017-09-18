package cinema.dao.impl;

import cinema.dao.AuditoriumDAO;
import cinema.entity.Auditorium;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriumDAOImpl implements AuditoriumDAO {

    private List<Auditorium> auditoriums = new ArrayList<>();
    @Override
    public Auditorium save(Auditorium auditorium) {
        auditoriums.add(auditorium);
        return auditorium;
    }

    @Override
    public Auditorium get(long id) {
        return auditoriums.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Auditorium update(Auditorium auditorium) {
        Auditorium currentUser = get(auditorium.getId());
        auditoriums.remove(currentUser);
        auditoriums.add(auditorium);

        return auditorium;
    }

    @Override
    public void delete(long id) {
        Auditorium event = get(id);
        auditoriums.remove(event);
    }

    @Override
    public List<Auditorium> getAll() {
        return auditoriums;
    }

    @Override
    public Auditorium getByName(String name) {
        return auditoriums.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
