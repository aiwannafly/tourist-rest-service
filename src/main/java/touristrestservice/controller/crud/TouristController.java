package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TouristApi;
import touristrestservice.model.entities.*;
import touristrestservice.service.*;

import java.util.List;

@RestController
public class TouristController extends BaseController<Tourist> implements TouristApi {

    private final TouristService service;

    @Autowired
    public TouristController(TouristService service) {
        this.service = service;
    }

    @Override
    BaseService<Tourist> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Tourist> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Tourist>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Tourist value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Tourist value) {
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

