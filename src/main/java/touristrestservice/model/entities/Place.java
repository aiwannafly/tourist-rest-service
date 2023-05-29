package touristrestservice.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "place")
public class Place extends BaseEntity {

    private String name;

    private String address;

    private Double latitude;

    private Double longitude;
}
