package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Route;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface RouteApi {
    String API = "/route";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Route> getById(@PathVariable("id") Long id);

    @GetMapping(value = "activities", produces = "application/json")
    ResponseEntity<List<Route>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Route> create(@RequestBody Route value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Route> update(@PathVariable("id") Long id, @RequestBody Route value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
