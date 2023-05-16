package touristrestservice.service;

import touristrestservice.model.entities.BaseEntity;
import touristrestservice.model.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    BaseRepository<T> getRepository();

    default T create(T t) {
        return getRepository().save(t);
    }

    default Optional<T> update(T t) {
        if (getRepository().existsById(t.getId())) {
            return Optional.of(getRepository().save(t));
        }
        return Optional.empty();
    }

    default Optional<T> get(Long id) {
        return getRepository().findById(id);
    }

    default List<T> getAll() {
        return getRepository().findAll();
    }

    default void delete(Long id) {
        getRepository().deleteById(id);
    }

}
