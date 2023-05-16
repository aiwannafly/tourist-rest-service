package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.*;
import touristrestservice.model.repository.*;

@Service
public class TouristService implements BaseService<Tourist> {

    TouristRepository repository;

    @Autowired
    void setRepository(TouristRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Tourist> getRepository() {
        return repository;
    }
}

