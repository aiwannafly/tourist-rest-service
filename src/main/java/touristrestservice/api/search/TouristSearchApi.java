package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;

import java.sql.Date;
import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TouristSearchApi {

    @GetMapping(value = "/search/tourists", produces = "application/json")
    ResponseEntity<List<Tourist>> findAll(@RequestParam List<String> genders,
                                          @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                          @RequestParam Integer maxBirthYear);

    @GetMapping(value = "/search/tourists/group/{id}", produces = "application/json")
    ResponseEntity<List<Tourist>> findByGroupId(@PathVariable("id") Long id);

    @GetMapping(value = "/search/tourists/trip/{id}", produces = "application/json")
    ResponseEntity<List<Tourist>> findAllByTrip(@PathVariable Long id, @RequestParam List<String> genders,
                                                @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                @RequestParam Integer maxBirthYear);

    @GetMapping(value = "/search/tourists/trips", produces = "application/json")
    ResponseEntity<List<Tourist>> findAllByTripsCount(@RequestParam List<String> genders,
                                                      @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                      @RequestParam Integer maxBirthYear,
                                                      @RequestParam(name = "count") Long tripsCount);

    @GetMapping(value = "/search/tourists/trip", produces = "application/json")
    ResponseEntity<List<Tourist>> findAllByTripDate(@RequestParam List<String> genders,
                                                    @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                    @RequestParam Integer maxBirthYear,
                                                    @RequestParam Date date);

    @GetMapping(value = "/search/tourists/route/{id}", produces = "application/json")
    ResponseEntity<List<Tourist>> findByRouteId(@RequestParam List<String> genders,
                                                @RequestParam List<String> skillCategories, @RequestParam Integer minBirthYear,
                                                @RequestParam Integer maxBirthYear, @PathVariable Long id);
}
