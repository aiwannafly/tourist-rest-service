package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Trainer;

import java.util.List;

public interface TrainerRepository extends BaseRepository<Trainer> {
    @Query("SELECT t FROM Trainer t WHERE t.section.id = :id")
    List<Trainer> findTrainersBySectionId(@Param("id") Long sectionId);
}

