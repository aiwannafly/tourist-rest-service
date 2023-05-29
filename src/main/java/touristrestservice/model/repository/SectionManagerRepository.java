package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.SectionManager;

import java.util.List;

public interface SectionManagerRepository extends BaseRepository<SectionManager> {
    @Query("SELECT t FROM SectionManager t " +
            "WHERE t.employmentYear >= :minEmploymentYear AND t.employmentYear <= :maxEmploymentYear" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "AND t.salary >= :minSalary AND t.salary <= :maxSalary " +
            "ORDER BY t.id ASC")
    List<SectionManager> findTrainersByGenderAndAgeAndSalary(@Param("minSalary") Integer minSalary, @Param("maxSalary") Integer maxSalary,
                                                             @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                             @Param("minEmploymentYear") Integer minEmploymentYear, @Param("maxEmploymentYear") Integer maxEmploymentYear);
}
