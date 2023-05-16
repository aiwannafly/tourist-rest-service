package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Competition;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface CompetitionApi {
    String API = "/competition";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Competition> getById(@PathVariable("id") Long id);

    @GetMapping(value = "activities", produces = "application/json")
    ResponseEntity<List<Competition>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Competition> create(@RequestBody Competition value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Competition> update(@PathVariable("id") Long id, @RequestBody Competition value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
