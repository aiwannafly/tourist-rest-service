package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.ScheduleApi;
import touristrestservice.model.entities.Schedule;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.ScheduleService;

import java.util.List;

@RestController
public class ScheduleController extends BaseController<Schedule> implements ScheduleApi {

    private final ScheduleService service;

    @Autowired
    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @Override
    BaseService<Schedule> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Schedule> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Schedule>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Schedule value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Schedule value) {
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
