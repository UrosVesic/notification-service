package rs.urosvesic.notificationservice.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import rs.urosvesic.notificationservice.dto.NotificationDto;

@RequiredArgsConstructor
//@Component
public class KafkaProducer {

    //private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Value("${producer.topic.name}")
    private String topicName;

    public void sendNotificationToTopic(NotificationDto notificationDto){
       // kafkaTemplate.send(topicName, notificationDto);
    }
}
