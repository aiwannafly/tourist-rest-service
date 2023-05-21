package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.ScheduleApi;
import touristrestservice.model.entities.Schedule;
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
    public ResponseEntity<Schedule> create(Schedule value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Schedule> update(Long id, Schedule value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
