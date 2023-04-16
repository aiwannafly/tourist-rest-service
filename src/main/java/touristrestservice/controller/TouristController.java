package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.TouristApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.TouristService;

import java.util.Optional;

@RestController
public class TouristController implements TouristApi {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @Override
    public ResponseEntity<Tourist> touristIdGet(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Tourist> res = touristService.getById(id);
        if (res.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return ResponseEntity.ok(res.get());
    }
}
