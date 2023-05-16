package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Activity;
import touristrestservice.model.repository.ActivityRepository;
import touristrestservice.model.repository.BaseRepository;

@Service
public class ActivityService implements BaseService<Activity> {

    ActivityRepository repository;

    @Autowired
    void setRepository(ActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Activity> getRepository() {
        return repository;
    }
}
