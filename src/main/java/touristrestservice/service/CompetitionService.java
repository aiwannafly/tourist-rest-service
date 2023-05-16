package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Competition;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.CompetitionRepository;

@Service
public class CompetitionService implements BaseService<Competition> {

    CompetitionRepository repository;

    @Autowired
    void setRepository(CompetitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Competition> getRepository() {
        return repository;
    }
}
