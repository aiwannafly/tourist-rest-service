package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Competition;

import java.util.List;

public interface CompetitionRepository extends BaseRepository<Competition> {
    @Query("SELECT c FROM Competition c " +
            "JOIN c.tourists t " +
            "WHERE t.group.trainer.section.id = :sectionId " +
            "GROUP BY c " +
            "HAVING COUNT(t) >= 1")
    List<Competition> getCompetitionBySection(@Param("sectionId") Long sectionId);
}
