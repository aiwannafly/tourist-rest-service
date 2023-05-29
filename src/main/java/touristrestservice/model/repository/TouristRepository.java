package touristrestservice.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;

import java.sql.Date;
import java.util.List;

public interface TouristRepository extends BaseRepository<Tourist> {

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.gender IN :genders AND t.skillCategory IN :skillCategories " +
            "AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategory(@Param("genders") List<String> genders,
                                                       @Param("skillCategories") List<SkillCategory> skillCategories,
                                                       @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear);

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.group.id = :groupId AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndGroup(@Param("genders") List<String> genders,
                                                               @Param("skillCategories") List<SkillCategory> skillCategories,
                                                               @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                               @Param("groupId") Long groupId);

    @Query("SELECT t FROM Tourist t " +
            "WHERE t.group.id = :groupId " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGroup(@Param("groupId") Long groupId);

    @Query("SELECT t FROM Tourist t" +
            " WHERE t.group.trainer.section.id = :sectionId AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndSection(@Param("genders") List<String> genders,
                                                                 @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                 @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                 @Param("sectionId") Long sectionId);

    @Query("SELECT t FROM Tourist t " +
            "WHERE size(t.trips) = :tripsCount AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTripsCount(@Param("genders") List<String> genders,
                                                                    @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                    @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                    @Param("tripsCount") Long tripsCount);

    @Query("SELECT t FROM Tourist t " +
            "WHERE :tripId IN (SELECT trip.id FROM t.trips trip) AND t.gender IN :genders AND t.skillCategory IN :skillCategories" +
            " AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTrip(@Param("genders") List<String> genders,
                                                              @Param("skillCategories") List<SkillCategory> skillCategories,
                                                              @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                              @Param("tripId") Long tripId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN t.trips trip " +
            "WHERE :date BETWEEN trip.startDate AND trip.endDate " +
            "AND t.gender IN :genders AND t.skillCategory IN :skillCategories " +
            "AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillCategoryAndTripDate(@Param("genders") List<String> genders,
                                                                  @Param("skillCategories") List<SkillCategory> skillCategories,
                                                                  @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                                  @Param("date") Date date);

    @Query("SELECT t FROM Tourist t " +
            "JOIN t.trips trip " +
            "WHERE trip.route.id = :routeId " +
            "AND t.gender IN :genders AND t.skillCategory IN :skillCategories " +
            "AND t.birthYear >= :minBirthYear AND t.birthYear <= :maxBirthYear " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillAndRoute(@Param("genders") List<String> genders,
                                                       @Param("skillCategories") List<SkillCategory> skillCategories,
                                                       @Param("minBirthYear") Integer minBirthYear, @Param("maxBirthYear") Integer maxBirthYear,
                                                       @Param("routeId") Long routeId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN t.trips trip " +
            "WHERE :placeId in (SELECT p.id FROM trip.route.places p) " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGenderAndSkillAndAttendedPlace(@Param("placeId") Long placeId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id IN (SELECT tt.id FROM trip.tourists tt)) " +
            "WHERE t.group.id = :groupId AND trip.instructor.id = t.group.trainer.tourist.id " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByGroupWhoHadTripWithTrainer(@Param("groupId") Long groupId);

    @Query("SELECT t FROM Tourist t " +
            "JOIN Trip trip ON (t.id IN (SELECT tt.id FROM trip.tourists tt)) " +
            "WHERE trip.route.id in :routeIds AND t.group.id = :groupId " +
            "GROUP BY t " +
            "ORDER BY t.id ASC")
    List<Tourist> findTouristsByTakenRoutes(@Param("groupId") Long groupId, @Param("routeIds") List<Long> routeIds);
}
