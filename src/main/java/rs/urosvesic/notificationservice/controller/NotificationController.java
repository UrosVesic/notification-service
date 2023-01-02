package rs.urosvesic.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.urosvesic.notificationservice.dto.NotificationDto;
import rs.urosvesic.notificationservice.service.NotificationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveNotification(@RequestBody NotificationDto notificationDto){
        notificationService.saveNotification(notificationDto);
    }

    @PatchMapping("/read/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void readNotification(@PathVariable String id){
        notificationService.readNotification(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationDto> getAllNotificationsForUser(){
        return notificationService.getAllNotificationsForUser();
    }
}
