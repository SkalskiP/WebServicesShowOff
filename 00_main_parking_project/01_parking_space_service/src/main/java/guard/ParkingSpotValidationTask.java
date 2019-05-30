package guard;

import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.ParkingTicketDTO;

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
        if (requestedTicket.getParkingSpot().getTriggerEventUuid() == triggerEventUuid && requestedTicket.getStatus() == ParkingTicketStatus.ARRIVED) {
            requestedTicket.setStatus(ParkingTicketStatus.UNPAID);
            ParkingTicketDAO.getInstance().updateItem(requestedTicket);
            //TODO: Send JMS
        }
        System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid);
    }
}
