package rs.urosvesic.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import rs.urosvesic.notificationservice.client.WebSocketClient;
import rs.urosvesic.notificationservice.dto.NotificationDto;

@Service
@RequiredArgsConstructor
public class WebSocketService {

    //private final KafkaProducer kafkaProducer;
    private final WebSocketClient webSocketClient;
    @Async
    public void notifyUser(NotificationDto notificationDto, String token) {
        //kafkaProducer.sendNotificationToTopic(notificationDto);
        webSocketClient.notifyForNotification(notificationDto, token);
    }
}
