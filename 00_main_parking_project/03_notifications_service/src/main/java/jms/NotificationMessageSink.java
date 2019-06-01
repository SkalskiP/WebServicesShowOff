package jms;

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
            Serializable msgObj = ((ObjectMessage) message).getObject();
            if (msgObj instanceof NewParkingSpotNotificationMessage) {
                System.out.println("SINK!!!");
                System.out.println(((NewParkingSpotNotificationMessage) msgObj).getSpotId());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}