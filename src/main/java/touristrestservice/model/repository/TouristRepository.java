package touristrestservice.model.repository;

import touristrestservice.model.entities.Tourist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepository extends CrudRepository<Tourist, Long> {
    Optional<Tourist> findById(Long id);
}
