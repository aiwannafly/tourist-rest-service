package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Trip;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.TripRepository;

@Service
public class TripService implements BaseService<Trip> {

    TripRepository repository;

    @Autowired
    void setRepository(TripRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Trip> getRepository() {
        return repository;
    }
}
