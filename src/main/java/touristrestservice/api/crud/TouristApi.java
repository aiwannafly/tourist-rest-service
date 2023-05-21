package touristrestservice.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.*;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface TouristApi {
    String API = "/tourist";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Tourist> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Tourist>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Tourist> create(@RequestBody Tourist value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Tourist> update(@PathVariable("id") Long id, @RequestBody Tourist value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}


