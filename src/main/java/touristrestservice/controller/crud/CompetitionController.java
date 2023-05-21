package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.CompetitionApi;
import touristrestservice.model.entities.Competition;
import touristrestservice.service.BaseService;
import touristrestservice.service.CompetitionService;

import java.util.List;

@RestController
public class CompetitionController extends BaseController<Competition> implements CompetitionApi {

    private final CompetitionService service;

    @Autowired
    public CompetitionController(CompetitionService service) {
        this.service = service;
    }

    @Override
    BaseService<Competition> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Competition> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Competition>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Competition> create(Competition value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Competition> update(Long id, Competition value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
