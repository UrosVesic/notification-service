package rs.urosvesic.notificationservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import rs.urosvesic.notificationservice.model.Notification;

@RequiredArgsConstructor
@Repository
public class CustomNotificationRepository {

    private final MongoTemplate template;

    public void readNotification(String id){
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = new Update().set("read",true);
        template.updateMulti(query,update, Notification.class);
    }
}
