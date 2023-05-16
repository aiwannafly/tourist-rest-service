package touristrestservice.model.entities;

import io.hypersistence.utils.hibernate.type.interval.PostgreSQLIntervalType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.sql.ast.tree.expression.Duration;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "start_date")
    private Date startDate;

    @Type(PostgreSQLIntervalType.class)
    @Column(name = "duration")
    private Duration duration;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Tourist instructor;

    @ManyToMany(mappedBy = "trips")
    private Set<Tourist> tourists = new HashSet<>();
}
