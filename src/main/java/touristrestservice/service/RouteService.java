package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Route;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.RouteRepository;

import java.sql.Date;
import java.util.List;

@Service
public class RouteService extends BaseService<Route> {

    RouteRepository repository;

    @Autowired
    void setRepository(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Route> getRepository() {
        return repository;
    }

    public List<Route> getRoutesBySection(Long sectionId) {
        return repository.getRoutesBySection(sectionId);
    }

    public List<Route> getRoutesByDate(Date date) {
        return repository.getRoutesByDate(date);
    }

    public List<Route> getRoutesByInstructor(Long instructorId) {
        return repository.getRoutesByInstructor(instructorId);
    }

    public List<Route> getRoutesByTripsCount(Integer tripsCount) {
        return repository.getRoutesByTripsCount(tripsCount);
    }

    public List<Route> getRoutesByPlace(Long placeId) {
        return repository.getRoutesByPlace(placeId);
    }

    public List<Route> getRoutesByMinLengthKm(Integer lengthKm) {
        return repository.getRoutesByMinLengthKm(lengthKm);
    }
}
