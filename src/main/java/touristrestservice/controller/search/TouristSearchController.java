package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.TouristSearchApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.service.TouristService;

import java.util.List;

@RestController
public class TouristSearchController implements TouristSearchApi {

    TouristService touristService;

    @Autowired
    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @Override
    public ResponseEntity<List<Tourist>> findAll(List<String> genders, List<String> skillCategories) {
        var enumSkills = skillCategories.stream().map(SkillCategory::fromString).toList();
        return ResponseEntity.ok(touristService.findTouristsByGenderAndSkillCategory(genders, enumSkills));
    }

    @Override
    public ResponseEntity<List<Tourist>> findByGroupId(Long id) {
        return ResponseEntity.ok(touristService.findTouristsByGroup(id));
    }
}
