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
    public Long save(Tourist tourist) {
        return null;
    }
}
