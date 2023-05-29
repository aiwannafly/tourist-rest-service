package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.TrainerSearchApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;
import touristrestservice.service.TrainerService;

import java.sql.Date;
import java.util.List;

@RestController
public class TrainerSearchController implements TrainerSearchApi {
    private TrainerService trainerService;

    @Autowired
    void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public ResponseEntity<List<Trainer>> findTrainersBySectionId(Long id) {
        return ResponseEntity.ok(trainerService.findTrainersBySectionId(id));
    }

    @Override
    public ResponseEntity<List<Trainer>> findAllByFilters(List<String> genders, Integer minSalary, Integer maxSalary, Integer minBirthYear, Integer maxBirthYear) {
        return ResponseEntity.ok(trainerService.findTrainersByGenderAndAgeAndSalary(genders, minSalary, maxSalary, minBirthYear, maxBirthYear));
    }

    @Override
    public ResponseEntity<List<Trainer>> findTrainersByGroupAndDate(Long groupId, Date startDate, Date endDate) {
        return ResponseEntity.ok(trainerService.findTrainersByGroupAndDate(groupId, startDate, endDate));
    }

    public ResponseEntity<List<Tourist>> findCandidatesForTrainer() {
        return ResponseEntity.ok(trainerService.findCandidatesForTrainer());
    }
}
