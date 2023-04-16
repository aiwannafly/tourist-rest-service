package touristrestservice.api;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Tourist;

@RequestMapping(Constants.BASE_API_PATH)
public interface TouristApi {

    @GetMapping(value = "/tourist/{id}", produces = "application/json")
    ResponseEntity<Tourist> touristIdGet(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException;
}
