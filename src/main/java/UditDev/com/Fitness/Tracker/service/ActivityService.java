package UditDev.com.Fitness.Tracker.service;

import UditDev.com.Fitness.Tracker.Model.Activity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final List<Activity> activities = new ArrayList<>();

    public Activity addActivity(String userId, String type, int steps, int caloriesBurned) {
        Activity activity = new Activity(UUID.randomUUID().toString(), userId, type, steps, caloriesBurned);
        activities.add(activity);
        return activity;
    }

    public List<Activity> getActivitiesByUser(String userId) {
        return activities.stream()
                .filter(activity -> activity.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}