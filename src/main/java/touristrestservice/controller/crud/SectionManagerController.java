package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.SectionManagerApi;
import touristrestservice.model.entities.SectionManager;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.SectionManagerService;

import java.util.List;

@RestController
public class SectionManagerController extends BaseController<SectionManager> implements SectionManagerApi {

    private final SectionManagerService service;

    @Autowired
    public SectionManagerController(SectionManagerService service) {
        this.service = service;
    }

    @Override
    BaseService<SectionManager> getService() {
        return service;
    }

    @Override
    public ResponseEntity<SectionManager> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<SectionManager>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(SectionManager value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, SectionManager value) {
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
