package dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "PARKING_SPOT")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParkingSpotDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "occupied", nullable = false)
    private Boolean occupied;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    @JsonIgnoreProperties("parkingSpots")
    private StreetDTO street;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="parkingSpot")
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

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
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
