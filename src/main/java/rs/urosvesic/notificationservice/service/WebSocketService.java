package rs.urosvesic.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.urosvesic.notificationservice.client.WebSocketClient;
import rs.urosvesic.notificationservice.dto.NotificationDto;
import rs.urosvesic.notificationservice.producer.KafkaProducer;

@Service
@RequiredArgsConstructor
public class WebSocketService {

    private final KafkaProducer kafkaProducer;
    private final WebSocketClient webSocketClient;
    public void notifyUser(NotificationDto notificationDto) {
        kafkaProducer.sendNotificationToTopic(notificationDto);
        //webSocketClient.notifyForNotification(notificationDto, UserUtil.getToken());
    }
}
