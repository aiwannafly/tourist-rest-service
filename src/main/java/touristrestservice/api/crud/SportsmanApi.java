package touristrestservice.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Sportsman;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface SportsmanApi {
    String API = "/sportsman";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Sportsman> getById(@PathVariable("id") Long id);

    @GetMapping(value = "/sportsmen", produces = "application/json")
    ResponseEntity<List<Sportsman>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Sportsman> create(@RequestBody Sportsman value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Sportsman> update(@PathVariable("id") Long id, @RequestBody Sportsman value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
