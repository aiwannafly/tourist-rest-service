package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Route;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.RouteRepository;

@Service
public class RouteService implements BaseService<Route> {

    RouteRepository repository;

    @Autowired
    void setRepository(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Route> getRepository() {
        return repository;
    }
}
