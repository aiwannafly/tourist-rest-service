package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.InstructorSearchApi;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.service.InstructorService;

import java.util.List;

@RestController
public class InstructorSearchController implements InstructorSearchApi {
    private InstructorService instructorService;

    @Autowired
    void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Override
    public List<Tourist> findInstructorsByTakenRoutes(List<Long> routeIds) {
        return instructorService.findInstructorsByTakenRoutes(routeIds);
    }

    @Override
    public List<Tourist> findInstructorsByTripsCount(Long tripsCount) {
        return instructorService.findInstructorsByTripsCount(tripsCount);
    }

    @Override
    public List<Tourist> findInstructorsByTrip(Long tripId) {
        return instructorService.findInstructorsByTrip(tripId);
    }

    @Override
    public List<Tourist> findInstructorsByCategory(SkillCategory category) {
        return instructorService.findInstructorsByCategory(category);
    }

    @Override
    public List<Tourist> findInstructorsByAttendedPlace(Long placeId) {
        return instructorService.findInstructorsByAttendedPlace(placeId);
    }

    @Override
    public List<Tourist> findCandidatesForInstructor() {
        return instructorService.findCandidatesForInstructor();
    }

    @Override
    public List<Tourist> findInstructorsWhoAreTrainers() {
        return instructorService.findInstructorsWhoAreTrainers();
    }

    @Override
    public List<Tourist> findInstructorsWhoAreSportsmen() {
        return instructorService.findInstructorsWhoAreSportsmen();
    }

    @Override
    public List<Tourist> findAllInstructors() {
        return instructorService.findAllInstructors();
    }
}
