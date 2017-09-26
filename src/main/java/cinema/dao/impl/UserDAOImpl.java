package cinema.dao.impl;

import cinema.dao.UserDAO;
import cinema.dao.mapper.UserMapper;
import cinema.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        String sql = "insert into users (first_name, last_name, email, password) values (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            return preparedStatement;
        }, keyHolder);

        long id = (long) keyHolder.getKeyList().get(0).get("id");
        user.setId(id);

        return user;
    }

    @Override
    public User get(long id) {
        String sql = "select * from users where id = ?";

        return jdbcTemplate.queryForObject(sql, userMapper, id);
    }

    @Override
    public User update(User user) {
        String sql = "update users set first_name = ?, last_name = ?, email = ?, password = ? where id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());

        return user;
    }

    @Override
    public void delete(long id) {
        String sql = "delete from users where id = ?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    @Override
    public User getByEmail(String email) {
        String sql = "select * from users where email = ?";

        return jdbcTemplate.queryForObject(sql, userMapper, email);
    }

}
