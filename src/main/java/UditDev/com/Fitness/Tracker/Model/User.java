package UditDev.com.Fitness.Tracker.Model;
// Filename: User.java

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    @Getter
    private String email;
    private String password;

}
