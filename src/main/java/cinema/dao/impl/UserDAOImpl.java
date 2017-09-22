package cinema.dao.impl;

import cinema.dao.UserDAO;
import cinema.dao.mapper.UserMapper;
import cinema.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        users.add(user);
        return user;
    }

    @Override
    public User get(long id) {
        String sql = "select * from users where id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, userMapper);
    }

    @Override
    public User update(User user) {
        User currentUser = get(user.getId());
        users.remove(currentUser);
        users.add(user);

        return user;
    }

    @Override
    public void delete(long id) {
        User user = get(id);
        users.remove(user);
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        return users;
    }

    @Override
    public User getByEmail(String email) {
        String sql = "select * from users where email = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{email}, userMapper);
    }

}
