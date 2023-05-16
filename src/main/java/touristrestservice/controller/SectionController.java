package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.SectionApi;
import touristrestservice.model.entities.Section;
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
    public ResponseEntity<Section> create(Section value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Section> update(Long id, Section value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
