package touristrestservice.model.repository;

import touristrestservice.model.entities.Route;
import touristrestservice.model.entities.Trip;

import java.sql.Date;
import java.util.List;

public interface TripRepository extends BaseRepository<Trip> {

    List<Trip> getTripsByStartDateAndRoute(Date startDate, Route route);
}
