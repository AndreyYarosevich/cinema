package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.dao.UserDAO;
import cinema.dao.impl.UserDAOImpl;
import cinema.entity.User;
import cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void remove(User user) {
        InMemmoryDataBaseSimulator.users.remove(user);
    }

    @Override
    public User getById(long id) {
        Optional<User> userOptional = InMemmoryDataBaseSimulator.users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();

        return userOptional.orElse(new User());
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> userOptional = InMemmoryDataBaseSimulator.users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();

        return userOptional.orElse(new User());
    }

    @Override
    public List<User> getAll() {

        return InMemmoryDataBaseSimulator.users;
    }
}
