package rs.urosvesic.notificationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import rs.urosvesic.notificationservice.dto.NotificationDto;

@FeignClient(name = "websocket-client", url = "${WEBSOCKET_SERVICE_SERVICE_HOST:http://localhost}:8084/api/websocket")
public interface WebSocketClient {

    @PostMapping("/notification")
    void notifyForNotification(@RequestBody NotificationDto notificationDto,
                  @RequestHeader(value = "Authorization") String authorizationHeader);


}
