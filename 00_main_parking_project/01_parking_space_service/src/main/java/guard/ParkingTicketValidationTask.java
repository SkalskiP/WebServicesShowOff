package guard;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;

import java.util.TimerTask;

public class ParkingTicketValidationTask extends TimerTask {

    private Integer ticketId;
    private String triggerEventUuid;

    public ParkingTicketValidationTask(Integer ticketId, String triggerEventUuid) {
        this.ticketId = ticketId;
        this.triggerEventUuid = triggerEventUuid;
    }

    public void run() {
        ParkingTicketDTO requestedTicket = ParkingTicketDAO.getInstance().getItem(ticketId);
        // This line is required due to the Lazy Evaluation of objects in relation.
        ParkingSpotDTO requestedSpot = ParkingSpotDAO.getInstance().getItem(requestedTicket.getParkingSpot().getId());
        // we need to use == and dot equals because of null pointers exceptions
        if (requestedSpot.getTriggerEventUuid() == triggerEventUuid && requestedSpot.getOccupied()) {
            requestedTicket.setStatus(ParkingTicketStatus.ALARM);
            ParkingTicketDAO.getInstance().updateItem(requestedTicket);
            //TODO: Send JMS
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS ALARM");
        } else {
            //TODO: Remove log
            System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATED AS CLOSED");
        }
    }
}

