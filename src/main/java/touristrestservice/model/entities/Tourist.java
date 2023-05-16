package touristrestservice.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import touristrestservice.model.entities.enums.SkillCategory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tourist")
@Getter
@Setter
@ToString
public class Tourist extends BaseEntity {
    private String gender;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_category")
    private SkillCategory skillCategory;

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
    private Set<Competition> competitions = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "attendance",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "activity_id") }
    )
    private Set<Activity> attendedActivities = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_trip",
            joinColumns = { @JoinColumn(name = "tourist_id") },
            inverseJoinColumns = { @JoinColumn(name = "trip_id") }
    )
    private Set<Trip> trips = new HashSet<>();
}
