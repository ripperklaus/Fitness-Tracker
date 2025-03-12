package UditDev.com.Fitness.Tracker.service;
import UditDev.com.Fitness.Tracker.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public User registerUser(String name, String email, String password) {
        if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            throw new IllegalArgumentException("Email already registered");
        }
        User user = new User(UUID.randomUUID().toString(), name, email, password);
        users.add(user);
        return user;
    }

    public Optional<User> loginUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }
}
