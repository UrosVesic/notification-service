package rs.urosvesic.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.urosvesic.notificationservice.dto.NotificationDto;
import rs.urosvesic.notificationservice.mapper.NotificationMapper;
import rs.urosvesic.notificationservice.model.Notification;
import rs.urosvesic.notificationservice.repository.CustomNotificationRepository;
import rs.urosvesic.notificationservice.repository.NotificationRepository;
import rs.urosvesic.notificationservice.util.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationMapper notificationMapper;
    private final NotificationRepository notificationRepository;
    private final CustomNotificationRepository customNotificationRepository;
    private final WebSocketService websocketService;
    @Transactional
    public void saveNotification(NotificationDto notificationDto) {
        Notification notification = notificationMapper.toEntity(notificationDto);
        notificationRepository.save(notification);
        websocketService.notifyUser(notificationDto, UserUtil.getToken());
    }


    public void readNotification(String id) {
        Notification chat = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat not found"));
        if(!chat.getReceiver().equals(UserUtil.getCurrentUsername())){
            throw new RuntimeException("You are not receiver of this notification");
        }
        customNotificationRepository.readNotification(id);
    }

    public List<NotificationDto> getAllNotificationsForUser() {
        return notificationRepository.findByReceiver(UserUtil.getCurrentUsername())
                .stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }
}
