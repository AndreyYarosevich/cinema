package cinema.dao.impl;

import cinema.dao.UserDAO;
import cinema.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User get(long id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
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
        return users;
    }

    @Override
    public User getByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

}
