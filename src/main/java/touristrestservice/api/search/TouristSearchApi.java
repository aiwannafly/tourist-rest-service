package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TouristSearchApi {

    @GetMapping(value = "/search/tourists", produces = "application/json")
    ResponseEntity<List<Tourist>> findAll(@RequestParam(name = "genders") List<String> genders,
                                          @RequestParam(name = "skillCategories") List<String> skillCategories);

    @GetMapping(value = "/search/tourists/group/{id}", produces = "application/json")
    ResponseEntity<List<Tourist>> findByGroupId(@PathVariable("id") Long id);
}
