package touristrestservice.api.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.util.List;

@RequestMapping(value = Constants.BASE_API_PATH, produces = "application/json")
public interface InstructorSearchApi {

    @GetMapping("/search/instructors")
    List<Tourist> findAllInstructors();

    @GetMapping("/search/instructors/trainers")
    List<Tourist> findInstructorsWhoAreTrainers();

    @GetMapping("/search/instructors/sportsmen")
    List<Tourist> findInstructorsWhoAreSportsmen();

    @GetMapping("/search/instructors/routes")
    List<Tourist> findInstructorsByTakenRoutes(@RequestParam List<Long> routeIds);

    @GetMapping("/search/instructors/byTripsCount")
    List<Tourist> findInstructorsByTripsCount(@RequestParam("value") Long tripsCount);

    @GetMapping("/search/instructors/trip/{id}")
    List<Tourist> findInstructorsByTrip(@PathVariable("id") Long tripId);

    @GetMapping("/search/instructors/category/{category}")
    List<Tourist> findInstructorsByCategory(@PathVariable SkillCategory category);

    @GetMapping("/search/instructors/place/{id}")
    List<Tourist> findInstructorsByAttendedPlace(@PathVariable("id") Long placeId);

    @GetMapping("/search/instructors/candidates")
    List<Tourist> findCandidatesForInstructor();
}
