package rs.urosvesic.notificationservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import rs.urosvesic.notificationservice.dto.NotificationDto;
import rs.urosvesic.notificationservice.service.NotificationService;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService notificationService;


    //@KafkaListener(topics = "${consumer.topic.name}",groupId = "notification-consumer")
    public void listenOnMessageTopic(String receivedNotification){
        try {
            System.out.println("Received message");
            ObjectMapper objectMapper = new ObjectMapper();
            NotificationDto notificationDto = objectMapper.readValue(receivedNotification, NotificationDto.class);
            notificationService.saveNotification(notificationDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Can't convert from JSON to NotificationResponse "+e.getMessage());
        }
    }
}
