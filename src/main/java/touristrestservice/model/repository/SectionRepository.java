package touristrestservice.model.repository;

import touristrestservice.model.entities.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Section, Long> {
}
