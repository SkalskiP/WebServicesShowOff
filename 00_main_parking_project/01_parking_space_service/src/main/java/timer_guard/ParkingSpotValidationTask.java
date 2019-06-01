package timer_guard;

import dao.*;
import domain.ParkingTicketStatus;
import dto.*;
import jms.NotificationMessageSource;

import java.util.Objects;
import java.util.TimerTask;

public class ParkingSpotValidationTask extends TimerTask {

    private NotificationMessageSource messageSource;
    private Integer ticketId;
    private String triggerEventUuid;

    public ParkingSpotValidationTask(Integer ticketId, String triggerEventUuid, NotificationMessageSource messageSource) {
        this.ticketId = ticketId;
        this.triggerEventUuid = triggerEventUuid;
        this.messageSource = messageSource;
    }

    public void run() {
        ParkingTicketDTO parkingTicket = ParkingTicketDAO.getInstance().getItem(ticketId);
        // This line is required due to the Lazy Evaluation of objects in relation.
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(parkingTicket.getParkingSpot().getId());
        if (Objects.equals(parkingSpot.getTriggerEventUuid(), triggerEventUuid) && parkingTicket.getStatus() == ParkingTicketStatus.ARRIVED) {
            parkingTicket.setStatus(ParkingTicketStatus.UNPAID);
            ParkingTicketDAO.getInstance().updateItem(parkingTicket);

            EmployeeDTO employee = parkingSpot.getStreet().getZone().getEmployee();
            messageSource.publish(
                    employee.getId(),
                    parkingSpot.getId(),
                    ticketId,
                    ParkingTicketStatus.UNPAID,
                    triggerEventUuid
            );
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS UNPAID");
        } else {
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS PAID");
        }
    }
}
