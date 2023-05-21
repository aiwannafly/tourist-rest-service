package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.sql.Date;
import java.util.List;

public interface TouristRepository extends BaseRepository<Tourist> {

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear")
    List<Tourist> findTouristsByGenderAndSkillCategory(@Param("genders") List<String> genders,
                                                       @Param("skillCategories") List<SkillCategory> skillCategories,
                                                       @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear);

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.group.id = :groupId AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndGroup(@Param("genders") List<String> genders,
                                                               @Param("skillCategories") List<SkillCategory> skillCategories,
                                                               @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                               @Param("groupId") Long groupId);

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.group.id = :groupId")
    List<Tourist> findTouristsByGroup(@Param("groupId") Long groupId);

    @Query("SELECT t FROM Tourist t" +
            " WHERE t.group.trainer.section.id = :sectionId AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndSection(@Param("genders") List<String> genders,
                                                                 @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                 @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                 @Param("sectionId") Long sectionId);

    @Query("SELECT t FROM Tourist t " +
            "WHERE size(t.trips) = :tripsCount AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTripsCount(@Param("genders") List<String> genders,
                                                                    @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                    @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                    @Param("tripsCount") Long tripsCount);

    @Query("SELECT t FROM Tourist t " +
            "WHERE :tripId IN (SELECT trip.id FROM t.trips trip) AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTrip(@Param("genders") List<String> genders,
                                                              @Param("skillCategories") List<SkillCategory> skillCategories,
                                                              @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                              @Param("tripId") Long tripId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN t.trips trip " +
            "WHERE :date BETWEEN trip.startDate AND trip.endDate " +
            "AND t.gender IN :genders AND t.skillCategory IN :skillCategories " +
            "AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "GROUP BY t HAVING count(trip) >= 1")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTripDate(@Param("genders") List<String> genders,
                                                                  @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                  @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                  @Param("date") Date date);

    @Query("SELECT t FROM Tourist t " +
            "JOIN t.trips trip " +
            "WHERE trip.route.id = :routeId " +
            "AND t.gender IN :genders AND t.skillCategory IN :skillCategories " +
            "AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "GROUP BY t HAVING count(trip) >= 1")
    List<Tourist> findTouristsByGenderAndSkillAndRoute(@Param("genders") List<String> genders,
                                                       @Param("skillCategories") List<SkillCategory> skillCategories,
                                                       @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                       @Param("routeId") Long routeId);
}
