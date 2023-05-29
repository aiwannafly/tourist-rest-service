package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.SectionManagerSearchApi;
import touristrestservice.model.entities.SectionManager;
import touristrestservice.service.SectionManagerService;

import java.util.List;

@RestController
public class SectionManagerSearchController implements SectionManagerSearchApi {
    private SectionManagerService sectionManagerService;

    @Autowired
    void setSectionManagerService(SectionManagerService sectionManagerService) {
        this.sectionManagerService = sectionManagerService;
    }

    @Override
    public ResponseEntity<List<SectionManager>> getFiltered(Integer minSalary, Integer maxSalary, Integer minBirthYear, Integer maxBirthYear, Integer minEmploymentYear, Integer maxEmploymentYear) {
        return ResponseEntity.ok(sectionManagerService.findTrainersByGenderAndAgeAndSalary(minSalary, maxSalary, minBirthYear, maxBirthYear, minEmploymentYear, maxEmploymentYear));
    }
}
