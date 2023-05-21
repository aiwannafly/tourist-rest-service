package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TripApi;
import touristrestservice.model.entities.Trip;
import touristrestservice.service.BaseService;
import touristrestservice.service.TripService;

import java.util.List;

@RestController
public class TripController extends BaseController<Trip> implements TripApi {

    private final TripService service;

    @Autowired
    public TripController(TripService service) {
        this.service = service;
    }

    @Override
    BaseService<Trip> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Trip> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Trip>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Trip> create(Trip value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Trip> update(Long id, Trip value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
