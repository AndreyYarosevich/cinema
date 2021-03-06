package cinema.dao.mapper;

import cinema.dao.AuditoriumDAO;
import cinema.entity.Auditorium;
import cinema.entity.AuditoriumSeat;
import cinema.entity.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditoriumSeatMapper implements RowMapper<AuditoriumSeat> {

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Override
    public AuditoriumSeat mapRow(ResultSet rs, int i) throws SQLException {
        AuditoriumSeat seat = new AuditoriumSeat();
        seat.setId(rs.getLong("id"));
        seat.setNumber(rs.getInt("number"));
        seat.setRow(rs.getInt("row"));
        seat.setType(SeatType.valueOf(rs.getString("type")));

        long auditoriumId = rs.getLong("auditorium_id");
        Auditorium auditorium = auditoriumDAO.get(auditoriumId);
        seat.setAuditorium(auditorium);

        return seat;
    }

}
