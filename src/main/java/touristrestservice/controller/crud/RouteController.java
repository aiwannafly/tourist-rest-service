package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.RouteApi;
import touristrestservice.model.entities.Route;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.RouteService;

import java.util.List;

@RestController
public class RouteController extends BaseController<Route> implements RouteApi {

    private final RouteService service;

    @Autowired
    public RouteController(RouteService service) {
        this.service = service;
    }

    @Override
    BaseService<Route> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Route> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Route>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Route value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Route value) {
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
