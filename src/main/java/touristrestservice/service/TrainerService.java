package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Trainer;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.TrainerRepository;

@Service
public class TrainerService implements BaseService<Trainer> {

    TrainerRepository repository;

    @Autowired
    void setRepository(TrainerRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Trainer> getRepository() {
        return repository;
    }
}
