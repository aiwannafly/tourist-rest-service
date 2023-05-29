package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.util.List;

public interface InstructorRepository extends BaseRepository<Tourist> {
    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "WHERE trip.route.id in :routeIds " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsByTakenRoutes(@Param("routeIds") List<Long> routeIds);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "GROUP BY t " +
            "HAVING COUNT(trip) = :tripsCount " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsByTripsCount(@Param("tripsCount") Long tripsCount);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id AND trip.id = :tripId) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsByTrip(@Param("tripId") Long tripId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "WHERE t.skillCategory = :category " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsByCategory(@Param("category") SkillCategory category);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "WHERE :placeId in (SELECT p.id FROM trip.route.places p) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsByAttendedPlace(@Param("placeId") Long placeId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findAllInstructors();

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.id IN (SELECT tr.tourist.id FROM Trainer tr) " +
            "OR t.id IN (SELECT sp.tourist.id FROM Sportsman sp) " +
            "ORDER BY t.id ASC")
    List<Tourist> findCandidatesForInstructor();

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "WHERE t.id IN (SELECT tr.id FROM Trainer tr) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsWhoAreTrainers();

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id = trip.instructor.id) " +
            "WHERE t.id IN (SELECT tr.id FROM Sportsman tr) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findInstructorsWhoAreSportsmen();
}
