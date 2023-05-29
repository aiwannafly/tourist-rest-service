package touristrestservice.api.search;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Competition;

import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface CompetitionSearchApi {

    @GetMapping(value = "/search/competitions/section/{id}", produces = "application/json")
    ResponseEntity<List<Competition>> getCompetitionsBySection(@PathVariable Long id);
}
