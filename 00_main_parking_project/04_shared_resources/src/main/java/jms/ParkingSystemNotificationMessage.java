package jms;

import domain.ParkingTicketStatus;

import java.io.Serializable;

public class ParkingSystemNotificationMessage implements Serializable {
    private Integer employeeId;
    private Integer spotId;
    private Integer ticketId;
    private ParkingTicketStatus status;
    private String triggerEventUuid;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTriggerEventUuid() {
        return triggerEventUuid;
    }

    public void setTriggerEventUuid(String triggerEventUuid) {
        this.triggerEventUuid = triggerEventUuid;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParkingSystemNotificationMessage = {" + "\n" +
                "employeeId=" + employeeId + "\n" +
                ", spotId=" + spotId + "\n" +
                ", ticketId=" + ticketId + "\n" +
                ", status=" + status + "\n" +
                ", triggerEventUuid='" + triggerEventUuid + '\'' + "\n" +
                '}';
    }
}