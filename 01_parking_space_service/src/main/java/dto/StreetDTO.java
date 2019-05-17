package dto;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "STREET")
@Access(AccessType.FIELD)
public class StreetDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private ZoneDTO zone;

    @OneToMany(mappedBy="street")
    private Set<ParkingSpotDTO> parkingSpots;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZoneDTO getZone() {
        return zone;
    }

    public void setZone(ZoneDTO zone) {
        this.zone = zone;
    }

    public Set<ParkingSpotDTO> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Set<ParkingSpotDTO> parking_spots) {
        this.parkingSpots = parking_spots;
    }
}
