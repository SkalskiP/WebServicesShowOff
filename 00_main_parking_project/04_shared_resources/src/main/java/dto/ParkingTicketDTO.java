package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import domain.ParkingTicketStatus;
import domain.ParkingTicketStatusConverter;
import utils.JsonDateDeserializer;
import utils.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity()
@Table(name = "PARKING_TICKET")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParkingTicketDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parking_spot_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("parkingTickets")
    private ParkingSpotDTO parkingSpot;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id", referencedColumnName = "id", nullable = true)
    private TicketTypeDTO ticketType;

    @Column(name = "arrival_time", nullable = false)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime arrivalTime;

    @Column(name = "payment_time", nullable = true)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime paymentTime;

    @Column(name = "expiry_time", nullable = true)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime expiryTime;

    @Column(name = "departure_time", nullable = true)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime departureTime;

    @Column(name = "status", nullable = false)
    @Convert(converter = ParkingTicketStatusConverter.class)
    private ParkingTicketStatus status;

    public ParkingTicketDTO() {}

    public ParkingTicketDTO(ParkingSpotDTO parkingSpot) {
        this.parkingSpot = parkingSpot;
        this.arrivalTime = LocalDateTime.now();
        this.status = ParkingTicketStatus.ARRIVED;
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
