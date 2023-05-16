package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Amateur;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface AmateurApi {
    String API = "/amateur";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Amateur> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Amateur>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Amateur> create(@RequestBody Amateur value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Amateur> update(@PathVariable("id") Long id, @RequestBody Amateur value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
