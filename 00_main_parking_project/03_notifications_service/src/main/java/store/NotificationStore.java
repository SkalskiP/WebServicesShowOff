package store;
import jms.ParkingSystemNotificationMessage;
import java.util.*;
import java.util.stream.Collectors;

public class NotificationStore {

    private static NotificationStore instance;

    private HashMap<Integer, HashMap<Integer, ParkingSystemNotificationMessage>> usersMailbox;

    private NotificationStore() {
        usersMailbox = new HashMap<Integer, HashMap<Integer, ParkingSystemNotificationMessage>>();
    }

    public static NotificationStore getInstance() {
        if (instance == null) {
            synchronized (NotificationStore.class) {
                if (instance == null) {
                    instance = new NotificationStore();
                }
            }
        }
        return instance;
    }

    public void add(ParkingSystemNotificationMessage notification) {
        Integer employeeId = notification.getEmployeeId();
        Integer spotId = notification.getSpotId();
        if (usersMailbox.get(employeeId) != null) {
            usersMailbox.get(employeeId).put(spotId, notification);
        }
        else {
            usersMailbox.put(employeeId, new HashMap<Integer, ParkingSystemNotificationMessage>());
            usersMailbox.get(employeeId).put(spotId, notification);
        }
    }

    public List<ParkingSystemNotificationMessage> getNotificationsAll() {
        ArrayList<ArrayList<ParkingSystemNotificationMessage>> notificationsItems = new ArrayList<ArrayList<ParkingSystemNotificationMessage>>();
        Iterator iterator = usersMailbox.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            notificationsItems.add(this.getNotificationsByEmployee((Integer) pair.getKey()));
        }
        return notificationsItems.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public ArrayList<ParkingSystemNotificationMessage> getNotificationsByEmployee(Integer employeeId) {
        ArrayList<ParkingSystemNotificationMessage> notificationsItems = new ArrayList<ParkingSystemNotificationMessage>();
        if (usersMailbox.get(employeeId) != null) {
            Iterator iterator = usersMailbox.get(employeeId).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry)iterator.next();
                notificationsItems.add((ParkingSystemNotificationMessage) pair.getValue());
            }
        }
        return notificationsItems;
    }
}