package touristrestservice.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.*;
import touristrestservice.model.entities.enums.SkillCategory;
import touristrestservice.model.repository.*;

import java.sql.Date;
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

    public List<Tourist> findTouristsByGenderAndSkillCategory(List<String> genders, List<SkillCategory> skillCategories, Integer minBirthYear,
                                                              Integer maxBirthYear) {
        return repository.findTouristsByGenderAndSkillCategory(genders, skillCategories, minBirthYear, maxBirthYear);
    }

    public List<Tourist> findTouristsByGroup(Long groupId) {
        return repository.findTouristsByGroup(groupId);
    }

    public List<Tourist> findTouristsByGenderAndSkillCategoryAndSection(List<String> genders,
                                                                        List<SkillCategory> skillCategories, Integer minBirthYear,
                                                                        Integer maxBirthYear,
                                                                        Long sectionId) {
        return repository.findTouristsByGenderAndSkillCategoryAndSection(genders, skillCategories, minBirthYear, maxBirthYear, sectionId);
    }

    public List<Tourist> findTouristsByGenderAndSkillCategoryAndTripsCount(List<String> genders,
                                                                           List<SkillCategory> skillCategories, Integer minBirthYear,
                                                                           Integer maxBirthYear,
                                                                           Long tripsCount) {
        return repository.findTouristsByGenderAndSkillCategoryAndTripsCount(genders, skillCategories, minBirthYear, maxBirthYear, tripsCount);
    }

    public List<Tourist> findTouristsByGenderAndSkillCategoryAndTrip(List<String> genders,
                                                                     List<SkillCategory> skillCategories, Integer minBirthYear,
                                                                     Integer maxBirthYear,
                                                                     Long tripId) {
        return repository.findTouristsByGenderAndSkillCategoryAndTrip(genders, skillCategories, minBirthYear, maxBirthYear, tripId);
    }

    public List<Tourist> findTouristsByGenderAndSkillCategoryAndTripDate(List<String> genders,
                                                                         List<SkillCategory> skillCategories, Integer minBirthYear,
                                                                         Integer maxBirthYear,
                                                                         Date date) {
        return repository.findTouristsByGenderAndSkillCategoryAndTripDate(genders, skillCategories, minBirthYear, maxBirthYear, date);
    }

    public List<Tourist> findTouristsByGenderAndSkillAndRoute(List<String> genders,
                                                              List<SkillCategory> skillCategories, Integer minBirthYear,
                                                              Integer maxBirthYear,
                                                              Long routeId) {
        return repository.findTouristsByGenderAndSkillAndRoute(genders, skillCategories, minBirthYear, maxBirthYear, routeId);
    }
}
