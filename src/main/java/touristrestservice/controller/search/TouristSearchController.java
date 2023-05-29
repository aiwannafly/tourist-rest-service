package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.TouristSearchApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.service.TouristService;

import java.sql.Date;
import java.util.List;

@RestController
public class TouristSearchController implements TouristSearchApi {

    TouristService touristService;

    @Autowired
    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @Override
    public ResponseEntity<List<Tourist>> findAll(List<String> genders, List<String> skillCategories, Integer minBirthYear,
                                                 Integer maxBirthYear) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategory(genders, enumSkills, minBirthYear, maxBirthYear));
    }

    @Override
    public ResponseEntity<List<Tourist>> findByGroupId(Long id) {
        return ResponseEntity.ok(touristService.findTouristsByGroup(id));
    }

    @Override
    public ResponseEntity<List<Tourist>> findAllByTrip(Long id, List<String> genders, List<String> skillCategories, Integer minBirthYear,
                                                       Integer maxBirthYear) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategoryAndTrip(genders, enumSkills, minBirthYear, maxBirthYear, id));
    }

    @Override
    public ResponseEntity<List<Tourist>> findAllByTripsCount(List<String> genders, List<String> skillCategories, Integer minBirthYear,
                                                             Integer maxBirthYear, Long tripsCount) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategoryAndTripsCount(genders, enumSkills, minBirthYear, maxBirthYear, tripsCount));
    }

    @Override
    public ResponseEntity<List<Tourist>> findAllByTripDate(List<String> genders, List<String> skillCategories, Integer minBirthYear,
                                                           Integer maxBirthYear, Date date) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategoryAndTripDate(genders, enumSkills, minBirthYear, maxBirthYear, date));
    }

    @Override
    public ResponseEntity<List<Tourist>> findByRouteId(List<String> genders, List<String> skillCategories, Integer minBirthYear,
                                                       Integer maxBirthYear, Long id) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillAndRoute(genders, enumSkills, minBirthYear, maxBirthYear, id));
    }

    @Override
    public ResponseEntity<List<Tourist>> findTouristsByGenderAndSkillCategoryAndGroup(List<String> genders,
                                                                                      List<SkillCategory> skillCategories,
                                                                                      Integer minBirthYear, Integer maxBirthYear,
                                                                                      Long groupId) {
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategoryAndGroup(genders, skillCategories, minBirthYear, maxBirthYear, groupId));
    }

    @Override
    public ResponseEntity<List<Tourist>> findTouristsByAttendedPlace(Long placeId) {
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillAndAttendedPlace(placeId));
    }

    @Override
    public ResponseEntity<List<Tourist>> findTouristsByGroupWhoHadTripWithTrainer(Long groupId) {
        return ResponseEntity.ok(touristService.findTouristsByGroupWhoHadTripWithTrainer(groupId));
    }

    @Override
    public ResponseEntity<List<Tourist>> findTouristsByTakenRoutes(Long groupId, List<Long> routeIds) {
        return ResponseEntity.ok(touristService.findTouristsByTakenRoutes(groupId, routeIds));
    }
}
