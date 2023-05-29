package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Sportsman;
import touristrestservice.model.entities.Trainer;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SportsmanRepository;
import touristrestservice.model.repository.TrainerRepository;

import java.util.List;

@Service
public class SportsmanService extends BaseService<Sportsman> {

    SportsmanRepository repository;
    TrainerRepository trainerRepository;

    @Autowired
    void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Autowired
    void setRepository(SportsmanRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void validateBeforeSave(Sportsman s) {
        List<Trainer> allTrainers = trainerRepository.findAll();
        List<Sportsman> allSportsmen = repository.findAll();
        boolean conflictTr = allTrainers.stream().anyMatch((tr) -> tr.getTourist().equals(s.getTourist()));
        if (conflictTr) {
            throw new IllegalArgumentException("This tourist is a trainer. He can not be a sportsman at the same time.");
        }
        boolean conflictSp = allSportsmen.stream().anyMatch((ss) -> s.getTourist().equals(ss.getTourist()) && !ss.getId().equals(s.getId()));
        if (conflictSp) {
            throw new IllegalArgumentException("This tourist is a sportsman already.");
        }
    }

    @Override
    public BaseRepository<Sportsman> getRepository() {
        return repository;
    }
}
