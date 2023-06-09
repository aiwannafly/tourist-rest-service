package touristrestservice.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.crud.GroupApi;
import touristrestservice.model.entities.Group;
import touristrestservice.model.entities.Tourist;
import touristrestservice.service.BaseService;
import touristrestservice.service.GroupService;

import java.util.List;
import java.util.Objects;

@RestController
public class GroupController extends BaseController<Group> implements GroupApi {

    private final GroupService service;

    @Autowired
    public GroupController(GroupService service) {
        this.service = service;
    }

    @Override
    BaseService<Group> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Group> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<Group>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity create(Group value) {
        try {
            return super.create(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(Long id, Group value) {
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
