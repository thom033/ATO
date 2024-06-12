package itu.notification;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class NotificationJSONController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/notification/liste")
    public HashMap<String, Object> listeNotification(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("notifications", notificationRepository.findAll());

        return map;
    }
}
