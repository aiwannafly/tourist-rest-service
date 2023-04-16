package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tourist")
@Getter
@Setter
@ToString
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @ManyToOne
    @JoinTable(
            name = "tourist_group",
            joinColumns = { @JoinColumn(name = "tourist_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    private Group group;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_competition",
            joinColumns = { @JoinColumn(name = "tourist_id") },
            inverseJoinColumns = { @JoinColumn(name = "competition_id") }
    )
    Set<Competition> competitions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Tourist t = (Tourist) o;
        return Objects.equals(t.getId(), getId());
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(getId());
    }
}
