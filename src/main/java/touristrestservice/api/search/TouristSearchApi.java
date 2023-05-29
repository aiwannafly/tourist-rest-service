package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.sql.Date;
import java.util.List;

@RequestMapping(value = Constants.BASE_API_PATH, produces = "application/json")
public interface TouristSearchApi {

    @GetMapping(value = "/search/tourists")
    ResponseEntity<List<Tourist>> findAll(@RequestParam List<String> genders,
                                          @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                          @RequestParam Integer maxBirthYear);

    @GetMapping(value = "/search/tourists/group/{id}/filtered")
    ResponseEntity<List<Tourist>> findTouristsByGenderAndSkillCategoryAndGroup(@RequestParam List<String> genders,
                                                                               @RequestParam List<SkillCategory> skillCategories,
                                                                               @RequestParam Integer minBirthYear, @RequestParam Integer maxBirthYear,
                                                                               @PathVariable("id") Long groupId);

    @GetMapping(value = "/search/tourists/group/{id}")
    ResponseEntity<List<Tourist>> findByGroupId(@PathVariable("id") Long id);

    @GetMapping(value = "/search/tourists/trip/{id}")
    ResponseEntity<List<Tourist>> findAllByTrip(@PathVariable Long id, @RequestParam List<String> genders,
                                                @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                @RequestParam Integer maxBirthYear);

    @GetMapping(value = "/search/tourists/trips")
    ResponseEntity<List<Tourist>> findAllByTripsCount(@RequestParam List<String> genders,
                                                      @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                      @RequestParam Integer maxBirthYear,
                                                      @RequestParam(name = "count") Long tripsCount);

    @GetMapping(value = "/search/tourists/trip")
    ResponseEntity<List<Tourist>> findAllByTripDate(@RequestParam List<String> genders,
                                                    @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                    @RequestParam Integer maxBirthYear,
                                                    @RequestParam Date date);

    @GetMapping(value = "/search/tourists/route/{id}")
    ResponseEntity<List<Tourist>> findByRouteId(@RequestParam List<String> genders,
                                                @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                @RequestParam Integer maxBirthYear, @PathVariable Long id);

    @GetMapping(value = "/search/tourists/place/{id}")
    ResponseEntity<List<Tourist>> findTouristsByAttendedPlace(@PathVariable("id") Long placeId);

    @GetMapping(value = "/search/tourists/trainer-trip/group/{id}")
    ResponseEntity<List<Tourist>> findTouristsByGroupWhoHadTripWithTrainer(@PathVariable("id") Long groupId);

    @GetMapping(value = "/search/tourists/group/{id}/routes")
    ResponseEntity<List<Tourist>> findTouristsByTakenRoutes(@PathVariable("id") Long groupId, @RequestParam List<Long> routeIds);
}
