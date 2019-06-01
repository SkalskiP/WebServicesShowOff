package timer_guard;

import java.util.Timer;

public class ParkingSpotGuard {
    private static ParkingSpotGuard instance;
    private static Timer timer;

    private ParkingSpotGuard() {
        timer = new Timer();
    }

    public static ParkingSpotGuard getInstance() {
        if (instance == null) {
            synchronized (ParkingSpotGuard.class) {
                if (instance == null) {
                    instance = new ParkingSpotGuard();
                }
            }
        }
        return instance;
    }

    public void scheduleValidation(Integer parkingTicketId, String triggerEventUuid) {
        //TODO: Remove log
        System.out.println("TicketId " + parkingTicketId.toString() + ", triggerEventUuid " + triggerEventUuid + " VALIDATE PARKING SPOT SCHEDULED");
        timer.schedule(new ParkingSpotValidationTask(parkingTicketId, triggerEventUuid), 1 * 60 * 1000);
    }
}
