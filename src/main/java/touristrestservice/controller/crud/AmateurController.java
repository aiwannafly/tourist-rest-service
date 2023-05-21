package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.AmateurApi;
import touristrestservice.model.entities.Amateur;
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
    public ResponseEntity<Amateur> create(Amateur value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Amateur> update(Long id, Amateur value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
