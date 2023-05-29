package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.SectionApi;
import touristrestservice.model.entities.Section;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.SectionService;

import java.util.List;

@RestController
public class SectionController extends BaseController<Section> implements SectionApi {

    private final SectionService service;

    @Autowired
    public SectionController(SectionService service) {
        this.service = service;
    }

    @Override
    BaseService<Section> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Section> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Section>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Section value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Section value) {
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
