package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.SectionManager;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface SectionManagerApi {
    String API = "/sectionManager";

    @GetMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<SectionManager> getById(@PathVariable("id") Long id);

    @GetMapping(value = "activities", produces = "application/json")
    ResponseEntity<List<SectionManager>> getAll();

    @PostMapping(value = API, produces = "application/json")
    ResponseEntity<SectionManager> create(@RequestBody SectionManager value);

    @PostMapping(value = API + "/{id}", produces = "application/json")
    ResponseEntity<SectionManager> update(@PathVariable("id") Long id, @RequestBody SectionManager value);

    @DeleteMapping(value = API + "/{id}")
    ResponseEntity<Long> delete(@PathVariable("id") Long id);
}
