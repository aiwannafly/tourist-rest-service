package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.repository.TouristRepository;

import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristServiceImpl(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public Optional<Tourist> getById(Long id) {
        return touristRepository.findById(id);
    }

    @Override
    public Tourist save(Tourist tourist) {
        tourist.setId(null);
        return touristRepository.save(tourist);
    }

    @Override
    public Optional<Tourist> update(Long id, Tourist tourist) {
        Optional<Tourist> prevTourist = touristRepository.findById(id);
        if (prevTourist.isEmpty()) {
            return Optional.empty();
        }
        tourist.setId(id);
        touristRepository.save(tourist);
        return Optional.of(tourist);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Tourist> tourist = touristRepository.findById(id);
        if (tourist.isEmpty()) {
            return false;
        }
        touristRepository.delete(tourist.get());
        return true;
    }
}
