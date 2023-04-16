package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "competition")
@Getter
@Setter
@ToString
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Timestamp date;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_competition",
            joinColumns = { @JoinColumn(name = "competition_id") },
            inverseJoinColumns = { @JoinColumn(name = "tourist_id") }
    )
    private Set<Tourist> tourists = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(getId());
    }
}
