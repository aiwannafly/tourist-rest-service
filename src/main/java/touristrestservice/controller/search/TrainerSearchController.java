package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.TrainerSearchApi;
import touristrestservice.model.entities.Trainer;
import touristrestservice.service.TrainerService;

import java.util.List;

@RestController
public class TrainerSearchController implements TrainerSearchApi {
    private TrainerService trainerService;

    @Autowired
    void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public ResponseEntity<List<Trainer>> findTrainersBySectionId(Long sectionId) {
        return ResponseEntity.ok(trainerService.findTrainersBySectionId(sectionId));
    }

    @Override
    public ResponseEntity<List<Trainer>> findAllByFilters(List<String> genders, Integer minSalary, Integer maxSalary, Integer minBirthYear, Integer maxBirthYear) {
        return ResponseEntity.ok(trainerService.findTrainersByGenderAndAgeAndSalary(genders, minSalary, maxSalary, minBirthYear, maxBirthYear));
    }
}
