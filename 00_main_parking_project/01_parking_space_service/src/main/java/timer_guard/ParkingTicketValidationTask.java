package timer_guard;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.EmployeeDTO;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;
import jms.NotificationMessageSource;

import java.util.Objects;
import java.util.TimerTask;

public class ParkingTicketValidationTask extends TimerTask {

    private NotificationMessageSource messageSource;
    private Integer ticketId;
    private String triggerEventUuid;

    public ParkingTicketValidationTask(Integer ticketId, String triggerEventUuid, NotificationMessageSource messageSource) {
        this.ticketId = ticketId;
        this.triggerEventUuid = triggerEventUuid;
        this.messageSource = messageSource;
    }

    public void run() {
        ParkingTicketDTO parkingTicket = ParkingTicketDAO.getInstance().getItem(ticketId);
        // This line is required due to the Lazy Evaluation of objects in relation.
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(parkingTicket.getParkingSpot().getId());
        // we need to use == and dot equals because of null pointers exceptions
        if (Objects.equals(parkingSpot.getTriggerEventUuid(), triggerEventUuid) && parkingSpot.getOccupied()) {
            parkingTicket.setStatus(ParkingTicketStatus.ALARM);
            ParkingTicketDAO.getInstance().updateItem(parkingTicket);

            EmployeeDTO employee = parkingSpot.getStreet().getZone().getEmployee();
            messageSource.publish(
                    employee.getId(),
                    parkingSpot.getId(),
                    ticketId,
                    ParkingTicketStatus.ALARM,
                    triggerEventUuid
            );
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS ALARM");
        } else {
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS CLOSED");
        }
    }
}

