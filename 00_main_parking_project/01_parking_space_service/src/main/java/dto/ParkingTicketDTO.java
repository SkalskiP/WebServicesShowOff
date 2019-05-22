package dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import domain.ParkingTicketStatus;
import domain.ParkingTicketStatusConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity()
@Table(name = "PARKING_TICKET")
@Access(AccessType.FIELD)
public class ParkingTicketDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parking_spot_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private ParkingSpotDTO parkingSpot;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference
    private TicketTypeDTO ticketType;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = true)
    private LocalDateTime endTime;

    @Column(name = "status", nullable = false)
    @Convert(converter = ParkingTicketStatusConverter.class)
    private ParkingTicketStatus status;

    public ParkingTicketDTO() {}

    public ParkingTicketDTO(ParkingSpotDTO parkingSpot) {
        this.parkingSpot = parkingSpot;
        this.startTime = LocalDateTime.now();
        this.status = ParkingTicketStatus.UNPAID;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParkingSpotDTO getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpotDTO parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public TicketTypeDTO getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypeDTO ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}
