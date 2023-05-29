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
@Table(name = "section_manager")
@ToString(exclude = {"sectionSet"})
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "sectionSet"}, allowSetters = true)
public class SectionManager extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "employment_year")
    private Integer employmentYear;

    private Integer salary;

    @OneToMany(mappedBy = "sectionManager", fetch = FetchType.LAZY)
    private Set<Section> sectionSet;
}
