package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SportsmanRepository;
import touristrestservice.model.repository.TrainerRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService extends BaseService<Trainer> {

    TrainerRepository repository;

    SportsmanRepository sportsmanRepository;

    @Autowired
    void setRepository(TrainerRepository repository) {
        this.repository = repository;
    }

    @Autowired
    void setSportsmanRepository(SportsmanRepository sportsmanRepository) {
        this.sportsmanRepository = sportsmanRepository;
    }

    @Override
    public BaseRepository<Trainer> getRepository() {
        return repository;
    }

    @Override
    protected void validateBeforeSave(Trainer t) {
        List<Trainer> allTrainers = repository.findAll();
        List<Sportsman> allSportsmen = sportsmanRepository.findAll();
        boolean conflictTr = allTrainers.stream().anyMatch((tr) -> tr.getTourist().equals(t.getTourist()) && !tr.getId().equals(t.getId()));
        if (conflictTr) {
            throw new IllegalArgumentException("This tourist is a trainer already");
        }
        boolean conflictSp = allSportsmen.stream().anyMatch((s) -> s.getTourist().equals(t.getTourist()));
        if (conflictSp) {
            throw new IllegalArgumentException("This tourist is a sportsman. He can not be a trainer at the same time.");
        }
    }

    public List<Tourist> findCandidatesForTrainer() {
        return repository.findCandidatesForTrainer();
    }

    public List<Trainer> findTrainersByGenderAndAgeAndSalary(List<String> genders,
                                                             Integer minSalary, Integer maxSalary,
                                                             Integer minBirthYear, Integer maxBirthYear) {
        return repository.findTrainersByGenderAndAgeAndSalary(genders, minSalary, maxSalary, minBirthYear, maxBirthYear);
    }

    public List<Trainer> findTrainersBySectionId(Long sectionId) {
        return repository.findTrainersBySectionId(sectionId);
    }

    public List<Trainer> findTrainersByGroupAndDate(Long groupId, Date startDate, Date endDate) {
        return repository.findTrainersByGroupAndDate(groupId, startDate, endDate);
    }

    public Integer getTrainerWorkHours(Long trainerId, Date startDate,
                                       Date endDate) {
        return repository.getTrainerWorkHours(trainerId, startDate, endDate);
    }
}
