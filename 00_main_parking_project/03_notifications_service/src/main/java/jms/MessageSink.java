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
public class MessageSink implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Serializable msgObj = ((ObjectMessage) message).getObject();
            if (msgObj instanceof NewUnpaidParkingSpotMessage) {
                System.out.println("SINK!!!");
                System.out.println(((NewUnpaidParkingSpotMessage) msgObj).getSpotId());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}