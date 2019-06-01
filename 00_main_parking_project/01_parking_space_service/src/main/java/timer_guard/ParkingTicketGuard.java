package timer_guard;

import jms.NotificationMessageSource;

import java.util.Timer;

public class ParkingTicketGuard {
    private static ParkingTicketGuard instance;
    private static Timer timer;

    private ParkingTicketGuard() {
        timer = new Timer();
    }

    public static ParkingTicketGuard getInstance() {
        if (instance == null) {
            synchronized (ParkingTicketGuard.class) {
                if (instance == null) {
                    instance = new ParkingTicketGuard();
                }
            }
        }
        return instance;
    }

    public void scheduleValidation(Integer parkingTicketId, String triggerEventUuid, Integer timeDeltaMinutes, NotificationMessageSource messageSource) {
        //TODO: Remove log
        System.out.println("TicketId " + parkingTicketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATE PARKING TICKET SCHEDULED");
        timer.schedule(new ParkingTicketValidationTask(parkingTicketId, triggerEventUuid, messageSource), timeDeltaMinutes * 60 * 1000);
    }
}
