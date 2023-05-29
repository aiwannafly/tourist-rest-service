package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;

import java.sql.Date;
import java.util.List;

public interface TrainerRepository extends BaseRepository<Trainer> {
    @Query("SELECT t FROM Trainer t " +
            "WHERE t.tourist.gender IN :genders" +
            " AND t.tourist.birthYear >= :minBirthYear AND t.tourist.birthYear <= :maxBirthYear " +
            "AND t.salary >= :minSalary AND t.salary <= :maxSalary " +
            "ORDER BY t.id ASC")
    List<Trainer> findTrainersByGenderAndAgeAndSalary(@Param("genders") List<String> genders,
                                                      @Param("minSalary") Integer minSalary, @Param("maxSalary") Integer maxSalary,
                                                      @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear);

    @Query("SELECT t FROM Trainer t WHERE t.section.id = :id " +
            "ORDER BY t.id ASC")
    List<Trainer> findTrainersBySectionId(@Param("id") Long sectionId);

    @Query("SELECT t FROM Trainer t " +
            "JOIN Group g ON (g.trainer.id = t.id) " +
            "JOIN Schedule s ON (s.group.id = g.id) " +
            "JOIN Activity a ON (a.schedule.id = s.id) " +
            "WHERE a.date BETWEEN :startDate AND :endDate AND g.id = :id " +
            "GROUP BY t " +
            "HAVING COUNT(a) >= 1 " +
            "ORDER BY t.id ASC")
    List<Trainer> findTrainersByGroupAndDate(@Param("id") Long groupId, @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate);

    @Query("SELECT SUM(s.durationMins) / 60 FROM Schedule s " +
            "JOIN Activity a ON a.schedule.id = s.id " +
            "WHERE s.group.trainer.id = :id " +
            "AND a.date BETWEEN :startDate AND :endDate")
    Integer getTrainerWorkHours(@Param("id") Long trainerId, @Param("startDate") Date startDate,
                                @Param("endDate") Date endDate);

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.id NOT IN (SELECT tr.tourist.id FROM Trainer tr) " +
            "AND t.id NOT IN (SELECT sp.tourist.id FROM Sportsman sp) " +
            "ORDER BY t.id ASC")
    List<Tourist> findCandidatesForTrainer();
}
