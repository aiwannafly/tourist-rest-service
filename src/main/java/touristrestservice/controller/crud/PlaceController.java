package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.PlaceApi;
import touristrestservice.model.entities.Place;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.PlaceService;

import java.util.List;

@RestController
public class PlaceController extends BaseController<Place> implements PlaceApi {
    private PlaceService placeService;

    @Autowired
    void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    BaseService<Place> getService() {
        return placeService;
    }

    @Override
    public ResponseEntity<Place> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Place>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Place value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Place value) {
        try {
            return super.update(id, value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(Long id) {
        try {
            return super.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
