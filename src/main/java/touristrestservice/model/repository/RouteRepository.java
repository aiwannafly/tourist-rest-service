package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Route;

import java.sql.Date;
import java.util.List;

public interface RouteRepository extends BaseRepository<Route> {

    @Query("SELECT r FROM Route r " +
            "JOIN Trip trip ON(trip.route.id = r.id) " +
            "JOIN trip.tourists tourist " +
            "WHERE tourist.group.trainer.section.id = :id " +
            "GROUP BY r " +
            "HAVING COUNT(tourist) >= 1")
    List<Route> getRoutesBySection(@Param("id") Long sectionId);

    @Query("SELECT r FROM Route r " +
            "JOIN Trip trip ON (trip.route.id = r.id) " +
            "WHERE :date BETWEEN trip.startDate AND trip.endDate " +
            "GROUP BY r " +
            "HAVING COUNT(trip) >= 1")
    List<Route> getRoutesByDate(@Param("date") Date date);

    @Query("SELECT r FROM Route r " +
            "JOIN Trip trip ON (trip.route.id = r.id) " +
            "WHERE trip.instructor.id = :id " +
            "GROUP BY r " +
            "HAVING COUNT(trip) >= 1")
    List<Route> getRoutesByInstructor(@Param("id") Long instructorId);

    @Query("SELECT r FROM Route r " +
            "JOIN Trip trip ON (trip.route.id = r.id) " +
            "GROUP BY r " +
            "HAVING COUNT(trip) = :count")
    List<Route> getRoutesByTripsCount(@Param("count") Integer tripsCount);

    @Query("SELECT r FROM Route r WHERE :id in (SELECT p.id FROM r.places p)")
    List<Route> getRoutesByPlace(@Param("id") Long placeId);

    @Query("SELECT r FROM Route r WHERE r.lengthKm >= :lengthKm")
    List<Route> getRoutesByMinLengthKm(@Param("lengthKm") Integer lengthKm);
}
