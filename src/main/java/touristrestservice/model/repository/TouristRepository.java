package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.util.List;

public interface TouristRepository extends BaseRepository<Tourist> {
    @Query("SELECT t FROM Tourist t WHERE t.gender IN :genders AND t.skillCategory IN :skillCategories")
    List<Tourist> findTouristsByGenderAndSkillCategory(@Param("genders") List<String> genders,
                                                       @Param("skillCategories") List<SkillCategory> skillCategories);

    @Query("SELECT t FROM Tourist t WHERE t.group.id = :groupId")
    List<Tourist> findTouristsByGroup(@Param("groupId") Long groupId);
}
