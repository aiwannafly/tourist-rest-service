package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Group;
import touristrestservice.model.entities.Tourist;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.GroupRepository;

import java.util.Objects;

@Service
public class GroupService extends BaseService<Group> {

    GroupRepository repository;

    @Autowired
    void setRepository(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Group> getRepository() {
        return repository;
    }

    @Override
    protected void validateBeforeSave(Group g) throws IllegalArgumentException {
        if (g.getTourists() != null) {
            if (g.getTourists().contains(g.getTrainer().getTourist())) {
                throw new IllegalArgumentException("Trainer can not be a group member");
            }
        }
    }
}
