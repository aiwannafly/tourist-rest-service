package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "section_manager")
public class SectionManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "employment_year")
    private Integer employmentYear;

    @OneToMany(mappedBy = "sectionManager", fetch = FetchType.LAZY)
    private Set<Section> sectionSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionManager manager = (SectionManager) o;
        return Objects.equals(getId(), manager.getId());
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(getId());
    }
}
