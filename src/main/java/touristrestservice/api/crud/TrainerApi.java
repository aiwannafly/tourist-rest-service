package touristrestservice.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Trainer;

import java.sql.Date;
import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TrainerApi {
    String API = "/trainer";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Trainer> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Trainer>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Trainer> create(@RequestBody Trainer value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Trainer> update(@PathVariable("id") Long id, @RequestBody Trainer value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);

    @GetMapping(value = API + "/{id}/hours", produces = "application/json")
    ResponseEntity<Integer> getWorkHours(@PathVariable("id") Long id, @RequestParam Date startDate, @RequestParam Date endDate);
}
