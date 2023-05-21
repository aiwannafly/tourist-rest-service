package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import touristrestservice.model.entities.enums.SkillCategory;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "trip")
public class Trip extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "required_skill_category")
    private SkillCategory requiredSkillCategory;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Tourist instructor;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_trip",
            joinColumns = { @JoinColumn(name = "trip_id") },
            inverseJoinColumns = { @JoinColumn(name = "tourist_id") }
    )
    private Set<Tourist> tourists = new HashSet<>();
}
