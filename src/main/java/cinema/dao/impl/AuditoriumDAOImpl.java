package cinema.dao.impl;

import cinema.dao.AuditoriumDAO;
import cinema.dao.mapper.AuditoriumMapper;
import cinema.dao.mapper.AuditoriumSeatMapper;
import cinema.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriumDAOImpl implements AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Auditorium> auditoriums = new ArrayList<>();

    @Override
    public Auditorium save(Auditorium auditorium) {
        auditoriums.add(auditorium);
        return auditorium;
    }

    @Override
    public Auditorium get(long id) {
        String sql = "SELECT * FROM auditoriums where id = ?";
        Auditorium auditorium = jdbcTemplate.queryForObject(sql, new Object[]{id}, new AuditoriumMapper());

        return auditorium;
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
