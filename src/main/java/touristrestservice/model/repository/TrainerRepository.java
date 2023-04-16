package touristrestservice.model.repository;

import touristrestservice.model.entities.Trainer;
import org.springframework.data.repository.CrudRepository;

public interface TrainerRepository extends CrudRepository<Trainer, Long> {
}
