package touristrestservice.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import touristrestservice.model.entities.Route;

import java.util.Optional;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
    Optional<Route> findRouteById(Long id);

//    Route saveUpdateRoute(Route route);
}
