package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Schedule;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.ScheduleRepository;

import java.util.List;
import java.util.Locale;

@Service
public class ScheduleService extends BaseService<Schedule> {

    ScheduleRepository repository;

    @Autowired
    void setRepository(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Schedule> getRepository() {
        return repository;
    }

    @Override
    protected void validateBeforeSave(Schedule s) {
        List<Schedule> all = repository.findByDayOfWeekAndGroupAndTimeOfDay(s.getDayOfWeek(), s.getGroup(), s.getTimeOfDay());
        if (all.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("Group " + s.getGroup().getName() + " already has an activity on "
                + s.getDayOfWeek().name().toLowerCase(Locale.ROOT) + " " +
                s.getTimeOfDay().toString().substring(0, s.getTimeOfDay().toString().length() - 3));
    }
}
