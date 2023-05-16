package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.RouteApi;
import touristrestservice.model.entities.Route;
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
    public ResponseEntity<Route> create(Route value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Route> update(Long id, Route value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
