package itu.notification;

import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    // @Autowired
    // HttpSession httpSession;

    @GetMapping("/notification/index")
    public ModelAndView notification(HttpSession session) {
        ModelAndView mv = new ModelAndView("template");
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            mv.setViewName("login/login-register");
            session.setAttribute("nextPage", "/notification/index");
        } else {
            mv.setViewName("template");
            List<Notification> notifications = notificationRepository
                    .findByUtilisateurId(utilisateur.getId());
            mv.addObject("notifications", notifications);
            mv.addObject("id", utilisateur.getId());
            mv.addObject("page", "notification/notification");
        }
        return mv;
    }

    @GetMapping("/notification/delete/{idNotification}")
    public String supprimer(@PathVariable("idNotification") String idNotification) {
        notificationRepository.deleteById(Long.valueOf(idNotification));
        return "redirect:/notification/index";
    }

}
