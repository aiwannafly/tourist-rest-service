package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.AmateurApi;
import touristrestservice.model.entities.Amateur;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.AmateurService;
import touristrestservice.service.BaseService;

import java.util.List;

@RestController
public class AmateurController extends BaseController<Amateur> implements AmateurApi {

    private final AmateurService service;

    @Autowired
    public AmateurController(AmateurService service) {
        this.service = service;
    }

    @Override
    BaseService<Amateur> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Amateur> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Amateur>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Amateur value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Amateur value) {
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
