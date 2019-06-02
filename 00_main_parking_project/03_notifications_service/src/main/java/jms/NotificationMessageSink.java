package jms;

import store.NotificationStore;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/parking-space/AlarmTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class NotificationMessageSink implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Serializable messageObject = ((ObjectMessage) message).getObject();
            if (messageObject instanceof ParkingSystemNotificationMessage) {
                NotificationStore.getInstance().add((ParkingSystemNotificationMessage) messageObject);
                //TODO: Remove logs
                System.out.println("New message received:");
                System.out.println(((ParkingSystemNotificationMessage) messageObject).toString());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}