package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Trainer;

import java.util.List;

public interface TrainerRepository extends BaseRepository<Trainer> {
    @Query("SELECT t FROM Trainer t " +
            "WHERE t.tourist.gender IN :genders" +
            " AND t.tourist.birthYear >= :minBirthYear AND t.tourist.birthYear <= :maxBirthYear " +
            "AND t.salary >= :minSalary AND t.salary <= :maxSalary")
    List<Trainer> findTrainersByGenderAndAgeAndSalary(@Param("genders") List<String> genders,
                                                      @Param("minSalary") Integer minSalary, @Param("maxSalary") Integer maxSalary,
                                                      @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear);

    @Query("SELECT t FROM Trainer t WHERE t.section.id = :id")
    List<Trainer> findTrainersBySectionId(@Param("id") Long sectionId);
}

