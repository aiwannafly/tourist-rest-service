package touristrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.GroupApi;
import touristrestservice.model.entities.Group;
import touristrestservice.service.BaseService;
import touristrestservice.service.GroupService;

import java.util.List;

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
    public ResponseEntity<Group> create(Group value) {
        return super.create(value);
    }

    @Override
    public ResponseEntity<Group> update(Long id, Group value) {
        return super.update(id, value);
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return super.delete(id);
    }
}
