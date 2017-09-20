package cinema.dao.mapper;

import cinema.entity.Auditorium;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditoriumMapper implements RowMapper<Auditorium> {
    @Override
    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(resultSet.getLong("id"));
        auditorium.setName(resultSet.getString("name"));

        return auditorium;
    }
}
