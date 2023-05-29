package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.ActivityApi;
import touristrestservice.model.entities.Activity;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.ActivityService;
import touristrestservice.service.BaseService;

import java.util.List;

@RestController
public class ActivityController extends BaseController<Activity> implements ActivityApi {

    private final ActivityService service;

    @Autowired
    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @Override
    BaseService<Activity> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Activity> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Activity>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Activity value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Activity value) {
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
