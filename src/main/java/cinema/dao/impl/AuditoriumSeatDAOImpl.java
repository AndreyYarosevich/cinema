package cinema.dao.impl;

import cinema.dao.AuditoriumDAO;
import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.mapper.AuditoriumSeatMapper;
import cinema.entity.AuditoriumSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriumSeatDAOImpl implements AuditoriumSeatDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    private List<AuditoriumSeat> auditoriumSeats = new ArrayList<>();

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditorium) {
        auditoriumSeats.add(auditorium);
        return auditorium;
    }

    @Override
    public AuditoriumSeat get(long id) {
        String sql = "select * from auditorium_seats where id = ?";

        AuditoriumSeat seat = jdbcTemplate.queryForObject(sql, new Object[]{id}, new AuditoriumSeatMapper(auditoriumDAO));

        return seat;
    }

    @Override
    public AuditoriumSeat update(AuditoriumSeat auditorium) {
        AuditoriumSeat currentUser = get(auditorium.getId());
        auditoriumSeats.remove(currentUser);
        auditoriumSeats.add(auditorium);

        return auditorium;
    }

    @Override
    public void delete(long id) {
        AuditoriumSeat event = get(id);
        auditoriumSeats.remove(event);

    }
}
