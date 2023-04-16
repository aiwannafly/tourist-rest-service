package touristrestservice.service;

import touristrestservice.model.entities.Tourist;

import java.util.Optional;

public interface TouristService {

    Optional<Tourist> getById(Long id);

    Long save(Tourist tourist);
}
