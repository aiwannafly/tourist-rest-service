package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorService extends BaseService<Tourist> {
    private InstructorRepository instructorRepository;

    @Autowired
    void setInstructorRepository(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Tourist> findInstructorsByTakenRoutes(List<Long> routeIds) {
        return instructorRepository.findInstructorsByTakenRoutes(routeIds);
    }

    public List<Tourist> findInstructorsByTripsCount(Long tripsCount) {
        return instructorRepository.findInstructorsByTripsCount(tripsCount);
    }

    public List<Tourist> findInstructorsByTrip(Long tripId) {
        return instructorRepository.findInstructorsByTrip(tripId);
    }

    public List<Tourist> findInstructorsByCategory(SkillCategory category) {
        return instructorRepository.findInstructorsByCategory(category);
    }

    public List<Tourist> findInstructorsByAttendedPlace(Long placeId) {
        return instructorRepository.findInstructorsByAttendedPlace(placeId);
    }

    public List<Tourist> findInstructorsWhoAreTrainers() {
        return instructorRepository.findInstructorsWhoAreTrainers();
    }

    public List<Tourist> findInstructorsWhoAreSportsmen() {
        return instructorRepository.findInstructorsWhoAreSportsmen();
    }

    public List<Tourist> findAllInstructors() {
        return instructorRepository.findAllInstructors();
    }

    public List<Tourist> findCandidatesForInstructor() {
        return instructorRepository.findCandidatesForInstructor();
    }

    @Override
    public BaseRepository<Tourist> getRepository() {
        return instructorRepository;
    }
}
