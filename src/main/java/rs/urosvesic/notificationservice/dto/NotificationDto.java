package rs.urosvesic.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.urosvesic.notificationservice.model.NotificationType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto implements Dto{

    private Long postId;
    private String sender;
    private String receiver;
    private String message;
    private boolean read;
    private NotificationType notificationType;
}
