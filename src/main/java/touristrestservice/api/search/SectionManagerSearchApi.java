package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.SectionManager;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface SectionManagerSearchApi {

    @GetMapping(value = "/search/sectionManagers", produces = "application/json")
    ResponseEntity<List<SectionManager>> getFiltered(@RequestParam Integer minSalary,
                                                     @RequestParam Integer maxSalary,
                                                     @RequestParam Integer minBirthYear,
                                                     @RequestParam Integer maxBirthYear,
                                                     @RequestParam Integer minEmploymentYear,
                                                     @RequestParam Integer maxEmploymentYear);
}
