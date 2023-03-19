package rs.urosvesic.notificationservice.urls;

public interface Urls {

    static final String SAVE_NOTIFICATION = "/api/notification";
    static final String READ_NOTIFICATION = "/api/notification/read/{id}";
    static final String GET_ALL_NOTIFICATIONS_FOR_USER = "/api/notification/{username}";
}
