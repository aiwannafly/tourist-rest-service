package touristrestservice.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import touristrestservice.model.entities.enums.SkillCategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tourist")
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "attendedActivities",
"trips", "competitions"}, allowSetters = true)
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

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tourist_group",
            joinColumns = { @JoinColumn(name = "tourist_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    private Group group;

    @ManyToMany(mappedBy = "tourists")
    private Set<Competition> competitions = new HashSet<>();

    @ManyToMany(mappedBy = "attended")
    private Set<Activity> attendedActivities = new HashSet<>();

    @ManyToMany(mappedBy = "tourists")
    private Set<Trip> trips = new HashSet<>();
}
