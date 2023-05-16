package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Trip;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TripApi {
    String API = "/trip";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Trip> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Trip>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Trip> create(@RequestBody Trip value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Trip> update(@PathVariable("id") Long id, @RequestBody Trip value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
