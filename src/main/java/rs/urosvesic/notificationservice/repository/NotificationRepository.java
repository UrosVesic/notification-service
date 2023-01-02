package rs.urosvesic.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.urosvesic.notificationservice.model.Notification;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    public List<Notification> findByReceiver(String receiver);
}
