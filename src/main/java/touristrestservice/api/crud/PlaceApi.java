package touristrestservice.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Place;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface PlaceApi {
    String API = "/place";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Place> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Place>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Place> create(@RequestBody Place value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Place> update(@PathVariable("id") Long id, @RequestBody Place value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
