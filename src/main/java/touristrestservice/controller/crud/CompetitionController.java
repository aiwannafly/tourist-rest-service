package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.CompetitionApi;
import touristrestservice.model.entities.Competition;
import touristrestservice.model.entities.Tourist;
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
    public ResponseEntity create(Competition value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Competition value) {
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
