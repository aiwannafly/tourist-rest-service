package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Place;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.PlaceRepository;

@Service
public class PlaceService extends BaseService<Place> {
    private PlaceRepository placeRepository;

    @Autowired
    void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public BaseRepository<Place> getRepository() {
        return placeRepository;
    }
}
