package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Section;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface SectionApi {
    String API = "/section";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Section> getById(@PathVariable("id") Long id);

    @GetMapping(value = API + "s", produces = "application/json")
    ResponseEntity<List<Section>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<Section> create(@RequestBody Section value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<Section> update(@PathVariable("id") Long id, @RequestBody Section value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
