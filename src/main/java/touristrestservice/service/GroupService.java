package touristrestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristrestservice.model.entities.Group;
import touristrestservice.model.repository.BaseRepository;
import touristrestservice.model.repository.GroupRepository;

@Service
public class GroupService implements BaseService<Group> {

    GroupRepository repository;

    @Autowired
    void setRepository(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<Group> getRepository() {
        return repository;
    }
}
