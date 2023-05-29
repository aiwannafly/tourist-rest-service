package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Section;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SectionRepository;

@Service
public class SectionService extends BaseService<Section> {

    SectionRepository repository;

    @Autowired
    void setRepository(SectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Section> getRepository() {
        return repository;
    }
}
