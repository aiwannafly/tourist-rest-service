package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.CompetitionSearchApi;
import touristrestservice.model.entities.Competition;
import touristrestservice.service.CompetitionService;

import java.util.List;

@RestController
public class CompetitionSearchController implements CompetitionSearchApi {
    private CompetitionService competitionService;

    @Autowired
    void setCompetitionService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @Override
    public ResponseEntity<List<Competition>> getCompetitionsBySection(Long id) {
        return ResponseEntity.ok(competitionService.getCompetitionBySection(id));
    }
}
