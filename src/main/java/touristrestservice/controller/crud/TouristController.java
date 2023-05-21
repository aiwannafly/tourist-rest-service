package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.TouristApi;
import touristrestservice.model.entities.*;
import touristrestservice.service.*;

import java.util.List;

@RestController
public class TouristController extends BaseController<Tourist> implements TouristApi {

    private final TouristService service;

    @Autowired
    public TouristController(TouristService service) {
        this.service = service;
    }

    @Override
    BaseService<Tourist> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Tourist> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Tourist>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Tourist> create(Tourist value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Tourist> update(Long id, Tourist value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}

