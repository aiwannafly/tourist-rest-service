package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Schedule;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.ScheduleRepository;

@Service
public class ScheduleService implements BaseService<Schedule> {

    ScheduleRepository repository;

    @Autowired
    void setRepository(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Schedule> getRepository() {
        return repository;
    }
}
