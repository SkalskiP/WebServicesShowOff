package guard;

import java.util.Timer;

public class Guard {

    private static Guard instance;
    private static Timer ticketTimer;

    private Guard() {
        ticketTimer = new Timer();
    }

    public static Guard getInstance() {
        if (instance == null) {
            synchronized (Guard.class) {
                if (instance == null) {
                    instance = new Guard();
                }
            }
        }
        return instance;
    }

    public void scheduleTicketValidation(Integer ticketId, String triggerEventUuid) {
        ticketTimer.schedule(new TicketValidationTask(ticketId, triggerEventUuid), 10000);
    }
}
