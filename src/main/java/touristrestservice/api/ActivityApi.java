package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Activity;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface ActivityApi {
    String API = "/activity";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Activity> getById(@PathVariable("id") Long id);

    @GetMapping(value = "/activities", produces = "application/json")
    ResponseEntity<List<Activity>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Activity> create(@RequestBody Activity value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Activity> update(@PathVariable("id") Long id, @RequestBody Activity value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
