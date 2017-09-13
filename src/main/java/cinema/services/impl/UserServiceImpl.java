package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.pojo.User;
import cinema.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        InMemmoryDataBaseSimulator.users.add(user);

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
