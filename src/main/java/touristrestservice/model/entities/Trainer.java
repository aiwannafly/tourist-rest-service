package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id", referencedColumnName = "id")
    private Tourist tourist;

    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Trainer t = (Trainer) o;
        return Objects.equals(t.getId(), getId());
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(getId());
    }
}
