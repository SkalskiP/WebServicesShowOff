package guard;

import java.util.TimerTask;

public class TicketValidationTask extends TimerTask {

    private Integer ticketId;
    private String triggerEventUuid;

    public TicketValidationTask(Integer ticketId, String triggerEventUuid) {
        this.ticketId = ticketId;
        this.triggerEventUuid = triggerEventUuid;
    }

    public void run() {
        System.out.println("TicketId " + ticketId.toString() + ", triggerEventUuid " + triggerEventUuid);
    }
}
