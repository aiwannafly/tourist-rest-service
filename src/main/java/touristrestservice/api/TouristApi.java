package touristrestservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;

@RequestMapping(Constants.BASE_API_PATH)
public interface TouristApi {

    @GetMapping(value = "/tourist/{id}", produces = "application/json")
    ResponseEntity<Tourist> touristIdGet(@PathVariable("id") Long id);

    @PostMapping(value = "/tourist", produces = "application/json")
    ResponseEntity<Tourist> saveTourist(@RequestBody Tourist tourist);

    @PostMapping(value = "/tourist/{id}", produces = "application/json")
    ResponseEntity<Tourist> updateTourist(@PathVariable("id") Long id, @RequestBody Tourist tourist);

    @DeleteMapping(value = "/tourist/{id}")
    ResponseEntity<Long> deleteTourist(@PathVariable("id") Long id);
}
