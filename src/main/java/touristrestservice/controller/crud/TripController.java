package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TripApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;
import touristrestservice.model.entities.Trip;
import touristrestservice.service.BaseService;
import touristrestservice.service.TripService;

import java.sql.Date;
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
    public ResponseEntity create(Trip value) {
        try {
            value.setEndDate(calcEndDate(value));
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Trip value) {
        try {
            value.setEndDate(calcEndDate(value));
            return super.update(id, value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private Date calcEndDate(Trip value) {
        return new Date(value.getStartDate().getTime() + value.getDurationDays() * 24 * 60 * 60 * 1000);
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
