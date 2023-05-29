package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.SectionManager;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.SectionManagerRepository;

import java.util.List;

@Service
public class SectionManagerService extends BaseService<SectionManager> {

    SectionManagerRepository repository;

    @Autowired
    void setRepository(SectionManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<SectionManager> getRepository() {
        return repository;
    }

    public List<SectionManager> findTrainersByGenderAndAgeAndSalary(Integer minSalary, Integer maxSalary,
                                                                    Integer minBirthYear, Integer maxBirthYear,
                                                                    Integer minEmploymentYear, Integer maxEmploymentYear) {
        return repository.findTrainersByGenderAndAgeAndSalary(minSalary, maxSalary, minBirthYear, maxBirthYear, minEmploymentYear, maxEmploymentYear);
    }
}
