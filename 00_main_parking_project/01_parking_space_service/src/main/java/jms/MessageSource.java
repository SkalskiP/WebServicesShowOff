package jms;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Singleton
public class MessageSource {

    @Resource(mappedName = "java:/jms/parking-space/AlarmTopic")
    private Topic topic;

    @Inject
    private JMSContext context;

    public void publishAlarmMessage(Integer userId) {
        try {
            NewAlarmMessage alarmMessage = new NewAlarmMessage();
            alarmMessage.setSpotId(userId);
            context.createProducer().send(topic, alarmMessage);
            System.out.println("Message is send " + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
