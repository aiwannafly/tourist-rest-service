package touristrestservice.service;

import touristrestservice.model.entities.BaseEntity;
import touristrestservice.model.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity> {

    abstract BaseRepository<T> getRepository();

    public T create(T t) {
        validateBeforeSave(t);
        t.setId(0L);
        return getRepository().save(t);
    }

    public Optional<T> update(T t) {
        validateBeforeSave(t);
        if (getRepository().existsById(t.getId())) {
            return Optional.of(getRepository().save(t));
        }
        return Optional.empty();
    }

    public Optional<T> get(Long id) {
        return getRepository().findById(id);
    }

    public List<T> getAll() {
        return getRepository().findAllByOrderByIdAsc();
    }

    public boolean delete(Long id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

    protected void validateBeforeSave(T t) throws IllegalArgumentException {
    }
}
