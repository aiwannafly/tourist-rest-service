package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Amateur;
import touristrestservice.model.repository.AmateurRepository;
import touristrestservice.model.repository.BaseRepository;

@Service
public class AmateurService implements BaseService<Amateur> {

    AmateurRepository repository;

    @Autowired
    void setRepository(AmateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Amateur> getRepository() {
        return repository;
    }
}
