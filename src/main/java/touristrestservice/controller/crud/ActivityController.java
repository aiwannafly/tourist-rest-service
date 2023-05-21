package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.ActivityApi;
import touristrestservice.model.entities.Activity;
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
    public ResponseEntity<Activity> create(Activity value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Activity> update(Long id, Activity value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
