package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Schedule;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface ScheduleApi {
    String API = "/schedule";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Schedule> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Schedule>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Schedule> create(@RequestBody Schedule value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Schedule> update(@PathVariable("id") Long id, @RequestBody Schedule value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
