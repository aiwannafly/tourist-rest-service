package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Competition;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.CompetitionRepository;
import touristrestservice.model.repository.InstructorRepository;

import java.util.List;

@Service
public class CompetitionService extends BaseService<Competition> {

    CompetitionRepository repository;
    InstructorRepository instructorRepository;

    @Autowired
    void setInstructorRepository(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Autowired
    void setRepository(CompetitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Competition> getRepository() {
        return repository;
    }

    @Override
    protected void validateBeforeSave(Competition c) {
        List<Tourist> candidates = instructorRepository.findCandidatesForInstructor();
        for (Tourist participant : c.getTourists()) {
            if (!candidates.contains(participant)) {
                throw new IllegalArgumentException("Tourist " + participant.getFirstName() + " " + participant.getSecondName() +
                        " is not a sportsman neither trainer");
            }
        }
    }

    public List<Competition> getCompetitionBySection(Long sectionId) {
        return repository.getCompetitionBySection(sectionId);
    }
}
