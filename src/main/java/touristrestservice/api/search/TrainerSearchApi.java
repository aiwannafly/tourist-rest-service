package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Trainer;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TrainerSearchApi {

    @GetMapping(value = "/search/trainers/section/{id}", produces = "application/json")
    ResponseEntity<List<Trainer>> findTrainersBySectionId(@PathVariable Long id);

    @GetMapping(value = "/search/trainers", produces = "application/json")
    ResponseEntity<List<Trainer>> findAllByFilters(@RequestParam List<String> genders,
                                                   @RequestParam Integer minSalary,
                                                   @RequestParam Integer maxSalary,
                                                   @RequestParam Integer minBirthYear,
                                                   @RequestParam Integer maxBirthYear);
}
