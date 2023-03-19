package rs.urosvesic.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notification")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class Notification implements MyCollection{

    @Id
    private String id;
    private String sender;
    private String receiver;
    private Long postId;
    private boolean read;
    private LocalDateTime createdAt;
    private NotificationType notificationType;
}
