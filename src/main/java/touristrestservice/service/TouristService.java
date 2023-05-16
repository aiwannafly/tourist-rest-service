package touristrestservice.service;

import touristrestservice.model.entities.Tourist;

import java.util.Optional;

public interface TouristService {

    Optional<Tourist> getById(Long id);

    Tourist save(Tourist tourist);

    Optional<Tourist> update(Long id, Tourist tourist);

    boolean deleteById(Long id);
}
