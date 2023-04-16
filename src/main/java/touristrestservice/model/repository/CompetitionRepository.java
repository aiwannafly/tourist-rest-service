package touristrestservice.model.repository;

import touristrestservice.model.entities.Competition;
import org.springframework.data.repository.CrudRepository;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {
}
