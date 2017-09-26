package cinema.dao.impl;

import cinema.dao.AuditoriumDAO;
import cinema.dao.mapper.AuditoriumMapper;
import cinema.dao.mapper.AuditoriumSeatMapper;
import cinema.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriumDAOImpl implements AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumMapper auditoriumMapper;

    @Override
    public Auditorium save(Auditorium auditorium) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into auditoriums (name) values (?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auditorium.getName());
            
            return preparedStatement;
        }, keyHolder);

        long id = keyHolder.getKey().longValue();
        auditorium.setId(id);
        
        return auditorium;
    }

    @Override
    public Auditorium get(long id) {
        String sql = "SELECT * FROM auditoriums where id = ?";

        return jdbcTemplate.queryForObject(sql, auditoriumMapper, id);
    }

    @Override
    public Auditorium update(Auditorium auditorium) {
        String sql = "update auditoriums SET number = ? where id = ?";
        jdbcTemplate.update(sql, auditorium.getName());

        return auditorium;
    }

    @Override
    public void delete(long id) {
        String sql = "delete from auditoriums where id = ?";
        jdbcTemplate.update(sql, auditoriumMapper, id);
    }

    @Override
    public List<Auditorium> getAll() {
        String sql = "select * from auditoriums";
        List<Auditorium> auditoriums = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Auditorium.class));

        return auditoriums;
    }

    @Override
    public Auditorium getByName(String name) {
        String sql = "select * from auditoriums where name = ?";

        return jdbcTemplate.queryForObject(sql, auditoriumMapper, name);
    }
}
