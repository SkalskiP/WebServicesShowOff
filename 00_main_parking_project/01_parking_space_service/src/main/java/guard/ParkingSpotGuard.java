package guard;

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

    public void scheduleValidation(Integer parkingSpotId, String triggerEventUuid) {
        timer.schedule(new ParkingSpotValidationTask(parkingSpotId, triggerEventUuid), 3 * 60 * 1000);
    }
}
