package dto;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "PARKING_SPOT")
@Access(AccessType.FIELD)
public class ParkingSpotDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private StreetDTO street;

    @OneToMany(mappedBy="parkingSpot")
    private Set<ParkingTicketDTO> parkingTickets;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public StreetDTO getStreet() {
        return street;
    }

    public void setStreet(StreetDTO street) {
        this.street = street;
    }

    public Set<ParkingTicketDTO> getParkingTickets() {
        return parkingTickets;
    }

    public void setParkingTickets(Set<ParkingTicketDTO> parkingTickets) {
        this.parkingTickets = parkingTickets;
    }
}
