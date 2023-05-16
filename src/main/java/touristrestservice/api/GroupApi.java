package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Group;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface GroupApi {
    String API = "/group";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Group> getById(@PathVariable("id") Long id);

    @GetMapping(value = "activities", produces = "application/json")
    ResponseEntity<List<Group>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Group> create(@RequestBody Group value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Group> update(@PathVariable("id") Long id, @RequestBody Group value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
