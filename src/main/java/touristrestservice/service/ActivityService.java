package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Activity;
import touristrestservice.model.entities.Schedule;
import touristrestservice.model.repository.ActivityRepository;
import touristrestservice.model.repository.BaseRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Locale;

@Service
public class ActivityService extends BaseService<Activity> {

    ActivityRepository repository;

    @Autowired
    void setRepository(ActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Activity> getRepository() {
        return repository;
    }

    @Override
    protected void validateBeforeSave(Activity a) {
        DayOfWeek activityDayOfWeek = a.getDate().toLocalDate().getDayOfWeek();
        DayOfWeek scheduleDayOfWeek = a.getSchedule().getDayOfWeek();
        if (!activityDayOfWeek.equals(scheduleDayOfWeek)) {
            throw new IllegalArgumentException("This activity must be on " + scheduleDayOfWeek.name().toLowerCase(Locale.ROOT)
                    + " due to the schedule, not " + activityDayOfWeek.name().toLowerCase(Locale.ROOT));
        }
    }
}
