package touristrestservice.model.repository;

import touristrestservice.model.entities.Group;
import touristrestservice.model.entities.Schedule;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

public interface ScheduleRepository extends BaseRepository<Schedule> {

    List<Schedule> findByDayOfWeekAndGroupAndTimeOfDay(DayOfWeek dayOfWeek, Group group, Time timeOfDay);
}
