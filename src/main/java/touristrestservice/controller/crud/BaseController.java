package touristrestservice.controller.crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import touristrestservice.model.entities.BaseEntity;
import touristrestservice.service.BaseService;

import java.util.List;
import java.util.Optional;

public abstract class BaseController<T extends BaseEntity> {

    abstract BaseService<T> getService();

    public ResponseEntity<T> getById(Long id)  {
        Optional<T> res = getService().get(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.get());
    }

    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(getService().getAll());
    }

    public ResponseEntity<T> create(T value) {
        try {
            return ResponseEntity.ok(getService().create(value));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<T> update(Long id, T value) {
        value.setId(id);
        Optional<T> res = getService().update(value);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.get());
    }

    public ResponseEntity<Long> delete(Long id)  {
        if (!getService().delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
