package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "competition")
@Getter
@Setter
@ToString
public class Competition extends BaseEntity {

    private String name;

    private Date date;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_competition",
            joinColumns = { @JoinColumn(name = "competition_id") },
            inverseJoinColumns = { @JoinColumn(name = "tourist_id") }
    )
    private Set<Tourist> tourists = new HashSet<>();
}
