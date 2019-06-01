package timer_guard;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;

import java.util.Objects;
import java.util.TimerTask;

public class ParkingSpotValidationTask extends TimerTask {

    private Integer ticketId;
    private String triggerEventUuid;

    public ParkingSpotValidationTask(Integer ticketId, String triggerEventUuid) {
        this.ticketId = ticketId;
        this.triggerEventUuid = triggerEventUuid;
    }

    public void run() {
        ParkingTicketDTO requestedTicket = ParkingTicketDAO.getInstance().getItem(ticketId);
        // This line is required due to the Lazy Evaluation of objects in relation.
        ParkingSpotDTO requestedSpot = ParkingSpotDAO.getInstance().getItem(requestedTicket.getParkingSpot().getId());
        if (Objects.equals(requestedSpot.getTriggerEventUuid(), triggerEventUuid) && requestedTicket.getStatus() == ParkingTicketStatus.ARRIVED) {
            requestedTicket.setStatus(ParkingTicketStatus.UNPAID);
            ParkingTicketDAO.getInstance().updateItem(requestedTicket);
            //TODO: Send JMS

            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS UNPAID");
        } else {
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS PAID");
        }
    }
}
