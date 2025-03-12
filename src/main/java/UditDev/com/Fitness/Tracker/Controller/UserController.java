package UditDev.com.Fitness.Tracker.Controller;
import UditDev.com.Fitness.Tracker.Model.User;
import UditDev.com.Fitness.Tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> request) {
        try {
            User user = userService.registerUser(request.get("name"), request.get("email"), request.get("password"));
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> request) {
        Optional<User> user = userService.loginUser(request.get("email"), request.get("password"));
        return user.isPresent() ? ResponseEntity.ok("Login successful") : ResponseEntity.status(401).body("Invalid credentials");
    }
}
