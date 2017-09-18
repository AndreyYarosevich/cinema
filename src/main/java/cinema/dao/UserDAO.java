package cinema.dao;

import cinema.entity.User;

import java.util.List;

public interface UserDAO {

    User save(User user);

    User get(long id);

    User update(User user);

    void delete(long id);

    List<User> getAll();

    User getByEmail(String email);
}
