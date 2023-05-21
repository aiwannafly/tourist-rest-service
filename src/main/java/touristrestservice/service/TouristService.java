package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.*;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.model.repository.*;

import java.util.List;

@Service
public class TouristService implements BaseService<Tourist> {

    TouristRepository repository;

    @Autowired
    void setRepository(TouristRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Tourist> getRepository() {
        return repository;
    }

    public List<Tourist> findTouristsByGenderAndSkillCategory(List<String> genders, List<SkillCategory> skillCategories) {
        return repository.findTouristsByGenderAndSkillCategory(genders, skillCategories);
    }

    public List<Tourist> findTouristsByGroup(Long groupId) {
        return repository.findTouristsByGroup(groupId);
    }
}

