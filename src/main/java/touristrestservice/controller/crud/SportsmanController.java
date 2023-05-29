package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.SportsmanApi;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.SportsmanService;

import java.util.List;

@RestController
public class SportsmanController extends BaseController<Sportsman> implements SportsmanApi {

    private final SportsmanService service;

    @Autowired
    public SportsmanController(SportsmanService service) {
        this.service = service;
    }

    @Override
    BaseService<Sportsman> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Sportsman> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Sportsman>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Sportsman value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Sportsman value) {
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
