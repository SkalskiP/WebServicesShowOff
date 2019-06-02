package store;

import jms.ParkingSystemNotificationMessage;

import java.util.HashMap;
import java.util.List;

public class NotificationStore {

    private static NotificationStore instance;

    private HashMap<String, Object> usersMailbox;

    private NotificationStore() {
        usersMailbox = new HashMap<String, Object>();
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
        if (usersMailbox.get(notification.getEmployeeId().toString()) != null) {

        }
        else {

        }
    }

    public List<ParkingSystemNotificationMessage> getNotificationsAll() {
        return null;
    }

    public List<ParkingSystemNotificationMessage> getNotificationsByUser(Integer userId) {
        return null;
    }
}