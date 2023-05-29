package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.entities.Trainer;
import touristrestservice.model.entities.Trip;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SportsmanRepository;
import touristrestservice.model.repository.TrainerRepository;
import touristrestservice.model.repository.TripRepository;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class TripService extends BaseService<Trip> {

    TripRepository tripRepository;
    TrainerRepository trainerRepository;
    SportsmanRepository sportsmanRepository;

    @Autowired
    void setRepository(TripRepository repository) {
        this.tripRepository = repository;
    }

    @Autowired
    void setSportsmanRepository(SportsmanRepository sportsmanRepository) {
        this.sportsmanRepository = sportsmanRepository;
    }

    @Autowired
    void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    protected void validateBeforeSave(Trip t) {
        List<Trainer> allTrainers = trainerRepository.findAll();
        List<Sportsman> allSportsmen = sportsmanRepository.findAll();
        boolean contains = allTrainers.stream().anyMatch((trainer -> trainer.getTourist().equals(t.getInstructor())))
                || allSportsmen.stream().anyMatch((sportsman -> sportsman.getTourist().equals(t.getInstructor())));
        if (!contains) {
            throw new IllegalArgumentException("Instructor must be either a trainer or a sportsman");
        }
        if (t.getTourists().contains(t.getInstructor())) {
            throw new IllegalArgumentException("Instructor must not be a member of the group");
        }
        List<Trip> trips = tripRepository.getTripsByStartDateAndRoute(t.getStartDate(), t.getRoute());
        if (!trips.isEmpty()) {
            throw new IllegalArgumentException("There is already a trip on " + t.getRoute().getName() + " on " + t.getStartDate());
        }
        if (t.getInstructor().getSkillCategory().ordinal() < t.getRequiredSkillCategory().ordinal()) {
            throw new IllegalArgumentException("Instructor " + t.getInstructor().getFirstName() + " " + t.getInstructor().getSecondName() +
                    " has " + t.getInstructor().getSkillCategory().name().toLowerCase(Locale.ROOT) + " category, but " +
                    t.getRequiredSkillCategory().name().toLowerCase(Locale.ROOT)
                    + " is required for the trip");
        }
        for (Tourist tourist : t.getTourists()) {
            if (tourist.getSkillCategory().ordinal() < t.getRequiredSkillCategory().ordinal()) {
                throw new IllegalArgumentException("Tourist " + tourist.getFirstName() + " " + tourist.getSecondName() +
                        " has " + tourist.getSkillCategory().name().toLowerCase(Locale.ROOT) + " category, but " +
                        t.getRequiredSkillCategory().name().toLowerCase(Locale.ROOT)
                        + " is required for the trip");
            }
        }
    }

    @Override
    public BaseRepository<Trip> getRepository() {
        return tripRepository;
    }
}
