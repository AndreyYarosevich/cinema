package cinema.dao.impl;

import cinema.dao.AuditoriumSeatDAO;
import cinema.dao.mapper.AuditoriumSeatMapper;
import cinema.entity.AuditoriumSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriumSeatDAOImpl implements AuditoriumSeatDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumSeatMapper auditoriumSeatMapper;

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditoriumSeat) {
        String sql = "insert into auditorium_seats (number, row, type, auditorium_id) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, auditoriumSeat.getNumber());
            preparedStatement.setInt(2, auditoriumSeat.getRow());
            preparedStatement.setString(3, auditoriumSeat.getType().name());
            preparedStatement.setLong(4, auditoriumSeat.getAuditorium().getId());

            return preparedStatement;
        }, keyHolder);

        long id = (long) keyHolder.getKeyList().get(0).get("id");
        auditoriumSeat.setId(id);

        return auditoriumSeat;

    }

    @Override
    public AuditoriumSeat get(long id) {
        String sql = "select * from auditorium_seats where id = ?";
        AuditoriumSeat seat = jdbcTemplate.queryForObject(sql, auditoriumSeatMapper, id);

        return seat;
    }

    @Override
    public AuditoriumSeat update(AuditoriumSeat auditoriumSeat) {
        String sql = "update auditorium_seats SET number = ?, row = ?, type = ?, auditorium_id = ? where id = ?";
        jdbcTemplate.update(sql, auditoriumSeat.getNumber(), auditoriumSeat.getRow(), auditoriumSeat.getType().name(), auditoriumSeat.getAuditorium().getId());

        return auditoriumSeat;
    }

    @Override
    public void delete(long id) {
        String sql = "delete  from auditorium_seats where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
