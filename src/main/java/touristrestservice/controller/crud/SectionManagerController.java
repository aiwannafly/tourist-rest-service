package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.SectionManagerApi;
import touristrestservice.model.entities.SectionManager;
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
    public ResponseEntity<SectionManager> create(SectionManager value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<SectionManager> update(Long id, SectionManager value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
