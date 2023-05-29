package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TrainerApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;
import touristrestservice.service.BaseService;
import touristrestservice.service.TrainerService;

import java.sql.Date;
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
    public ResponseEntity create(Trainer value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Trainer value) {
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

    @Override
    public ResponseEntity<Integer> getWorkHours(Long id, Date startDate, Date endDate) {
        return ResponseEntity.ok(service.getTrainerWorkHours(id, startDate, endDate));
    }
}
