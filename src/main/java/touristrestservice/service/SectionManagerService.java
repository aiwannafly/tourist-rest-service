package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.SectionManager;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SectionManagerRepository;

@Service
public class SectionManagerService implements BaseService<SectionManager> {

    SectionManagerRepository repository;

    @Autowired
    void setRepository(SectionManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<SectionManager> getRepository() {
        return repository;
    }
}
