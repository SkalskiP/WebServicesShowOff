package jms;

import domain.ParkingTicketStatus;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Singleton
public class NotificationMessageSource {

    @Resource(mappedName = "java:/jms/parking-space/AlarmTopic")
    private Topic topic;

    @Inject
    private JMSContext context;

    public void publish(Integer employeeId, Integer spotId, Integer ticketId, ParkingTicketStatus status, String triggerEventUuid) {
        try {
            NewParkingSpotNotificationMessage message = new NewParkingSpotNotificationMessage();
            message.setEmployeeId(employeeId);
            message.setSpotId(spotId);
            message.setTicketId(ticketId);
            message.setStatus(status);
            message.setTriggerEventUuid(triggerEventUuid);
            context.createProducer().send(topic, message);
            //TODO: Remove logs
            System.out.println("JMS: Message has been send");
            System.out.println(message.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
