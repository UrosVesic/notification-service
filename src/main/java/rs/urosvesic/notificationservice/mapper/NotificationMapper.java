package rs.urosvesic.notificationservice.mapper;

import org.springframework.stereotype.Component;
import rs.urosvesic.notificationservice.dto.NotificationDto;
import rs.urosvesic.notificationservice.model.Notification;
import rs.urosvesic.notificationservice.model.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class NotificationMapper implements GenericMapper<NotificationDto, Notification> {
    @Override
    public Notification toEntity(NotificationDto dto) {
        return Notification
                .builder()
                .id(UUID.randomUUID().toString())
                .sender(dto.getSender())
                .receiver(dto.getReceiver())
                .postId(dto.getPostId())
                .read(false)
                .notificationType(dto.getNotificationType())
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public NotificationDto toDto(Notification entity) {
        NotificationDto build = NotificationDto.builder()
                .id(entity.getId())
                .notificationType(entity.getNotificationType())
                .read(entity.isRead())
                .postId(entity.getPostId())
                .receiver(entity.getReceiver())
                .sender(entity.getSender())
                .message(entity.getSender()
                        + " "
                        + convertToString(entity.getNotificationType())
                        + " "
                        + "your post")
                .build();
        return build;
    }

    private String convertToString(NotificationType notificationType) {
        if(notificationType.equals(NotificationType.COMMENT)) return "commented";
        return notificationType.toString().toLowerCase()+"d";
    }
}
