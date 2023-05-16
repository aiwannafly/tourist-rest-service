package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SportsmanRepository;

@Service
public class SportsmanService implements BaseService<Sportsman> {

    SportsmanRepository repository;

    @Autowired
    void setRepository(SportsmanRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Sportsman> getRepository() {
        return repository;
    }
}
