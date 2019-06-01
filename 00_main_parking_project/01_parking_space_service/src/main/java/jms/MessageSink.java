package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/SoaTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MessageSink implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Serializable msgObj = ((ObjectMessage) message).getObject();
            if (msgObj instanceof NewAlarmMessage) {
                System.out.println("SINK!!!");
                System.out.println(((NewAlarmMessage) msgObj).getSpotId());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}