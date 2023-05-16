package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.SportsmanApi;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.service.BaseService;
import touristrestservice.service.SportsmanService;

import java.util.List;

@RestController
public class SportsmanController extends BaseController<Sportsman> implements SportsmanApi {

    private final SportsmanService service;

    @Autowired
    public SportsmanController(SportsmanService service) {
        this.service = service;
    }

    @Override
    BaseService<Sportsman> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Sportsman> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Sportsman>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Sportsman> create(Sportsman value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Sportsman> update(Long id, Sportsman value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
