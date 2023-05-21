package touristrestservice.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "section_group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tourists"})
public class Group extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Tourist> tourists;
}
