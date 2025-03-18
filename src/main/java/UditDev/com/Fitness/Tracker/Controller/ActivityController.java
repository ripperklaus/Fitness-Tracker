package UditDev.com.Fitness.Tracker.Controller;

import UditDev.com.Fitness.Tracker.Model.Activity;
import UditDev.com.Fitness.Tracker.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/add")
    public ResponseEntity<Activity> addActivity(@RequestBody Map<String, String> request) {
        Activity activity = activityService.addActivity(
                request.get("userId"),
                request.get("type"),
                Integer.parseInt(request.get("steps")),
                Integer.parseInt(request.get("caloriesBurned"))
        );
        return ResponseEntity.ok(activity);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Activity>> getActivities(@PathVariable String userId) {
        return ResponseEntity.ok(activityService.getActivitiesByUser(userId));
    }
}