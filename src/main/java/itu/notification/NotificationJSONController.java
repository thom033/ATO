package itu.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class NotificationJSONController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping(value = "/notification/liste", produces = "application/json; charset=UTF-8")
    public List<Notification> listeNotification(HttpSession session) {
        return notificationRepository.findAll();
    }

    @GetMapping(value = "/notification/filter/{type}", produces = "application/json; charset=UTF-8")
    public List<Notification> listeNotification(HttpSession session, @PathVariable("type") int type) {
        List<Notification> notifications = new ArrayList<>();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (type ==  0) {
            notifications = notificationRepository.findByUtilisateurIdAndPointTrue(utilisateur.getId());
        }
        else if (type == 1) {
            notifications = notificationRepository.findByUtilisateurIdAndEntretienNotNullAndAndReussiteIsNull(utilisateur.getId());            
        }
        else if (type == 2) {
            notifications = notificationRepository.findByUtilisateurIdAndPosteNotNull(utilisateur.getId());
        }
        else if (type == 3) {
            notifications = notificationRepository.findByUtilisateurIdAndReussiteNotNull(utilisateur.getId());
        }
        else if (type == -1) {
            notifications = notificationRepository.findByUtilisateurId(utilisateur.getId());
        }
        System.out.println(type);
        return notifications;
    }
}
