package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Tourist> touristIdGet(Long id)  {
        Optional<Tourist> res = touristService.get(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity<Tourist> saveTourist(Tourist tourist) {
        try {
            return ResponseEntity.ok(touristService.create(tourist));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Tourist> updateTourist(Long id, Tourist tourist) {
        tourist.setId(id);
        Optional<Tourist> res = touristService.update(tourist);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity<Long> deleteTourist(Long id)  {
        touristService.delete(id);
//        if (!deleted) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
