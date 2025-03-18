package UditDev.com.Fitness.Tracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private String id;
    private String userId;
    private String type; // Example: "Running", "Walking"
    private int steps;
    private int caloriesBurned;
}