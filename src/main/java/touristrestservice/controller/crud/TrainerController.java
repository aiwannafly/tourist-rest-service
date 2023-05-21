package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TrainerApi;
import touristrestservice.model.entities.Trainer;
import touristrestservice.service.BaseService;
import touristrestservice.service.TrainerService;

import java.util.List;

@RestController
public class TrainerController extends BaseController<Trainer> implements TrainerApi {

    private final TrainerService service;

    @Autowired
    public TrainerController(TrainerService service) {
        this.service = service;
    }

    @Override
    BaseService<Trainer> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Trainer> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Trainer>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Trainer> create(Trainer value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Trainer> update(Long id, Trainer value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
