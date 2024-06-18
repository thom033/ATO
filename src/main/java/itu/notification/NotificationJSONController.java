package itu.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class NotificationJSONController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping(value = "/notification/liste", produces = "application/json; charset=UTF-8")
    public List<Notification> listeNotification(HttpSession session) {
        return notificationRepository.findAll();
    }
}
