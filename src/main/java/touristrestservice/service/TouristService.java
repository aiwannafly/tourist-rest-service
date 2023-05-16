package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.TouristRepository;

@Service
public class TouristService implements BaseService<Tourist> {

    TouristRepository touristRepository;

    @Autowired
    void setTouristRepository(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public BaseRepository<Tourist> getRepository() {
        return touristRepository;
    }
}
