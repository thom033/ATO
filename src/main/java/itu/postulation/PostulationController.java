package itu.postulation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.Compatibilite.PosteDetails;
import itu.Compatibilite.PosteDetailsRepository;
import itu.Compatibilite.PosteDetailsService;
import itu.Compatibilite.ResultAcceuilRepository;
import itu.entretien.Entretien;
import itu.entretien.EntretienRepository;
import itu.notification.Notification;
import itu.notification.NotificationRepository;
import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class PostulationController {

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @Autowired
    PostulationRepository postulationRepository;

    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @Autowired
    EntretienRepository entretienRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/postuler/{idPoste}")
    public String getMethodName(@PathVariable("idPoste") String idTravail, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        Postulation postulation = new Postulation();

        PosteDetails posteDetails = posteDetailsRepository
                .findById(Long.valueOf(idTravail)).orElseThrow(() -> new RuntimeException("PosteDetails not found"));

        postulation.setDate(LocalDateTime.now());
        postulation.setPoste(posteDetails);
        postulation.setUtilisateur(utilisateur);

        postulationRepository.save(postulation);
        return "redirect:/notification/index";
    }

    @GetMapping("/admin/postulation")
    public ModelAndView getMethodName() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "admin/postulation/index");
        return mv;
    }

    @GetMapping("/admin/delete/postulation/{idPostulation}")
    public String supprimer(@PathVariable("idPostulation") String idPostulation) {
        postulationRepository.deleteById(Long.valueOf(idPostulation));
        return "redirect:/admin/postulation";
    }

    @GetMapping("/admin/valider/postulation")
    public ModelAndView valider(@RequestParam("date") String date, @RequestParam("id") String idPostulation,
            @RequestParam("idUtilisateur") String idUtilisateur,
            HttpSession session) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateEntretien = LocalDateTime.parse(date, formatter);

        Utilisateur utilisateur = utilisateurRepository.getById(Long.valueOf(idUtilisateur));
        Notification notification = new Notification();
        notification.setDateNotification(LocalDateTime.now());
        notification.setMessage("Convocation à un entretien d'embauche");
        notification.setUtilisateur(utilisateur);

        Entretien entretien = new Entretien();
        entretien.setDateEntretien(dateEntretien);
        entretien.setDateEnvoi(LocalDateTime.now());

        Postulation postulation = postulationRepository.getById(Long.valueOf(idPostulation));
        entretien.setPoste(postulation.getPoste());
        entretien.setReussite(false);
        entretien.setUtilisateur(utilisateur);
        entretienRepository.save(entretien);

        notification.setEntretien(entretien);
        notificationRepository.save(notification);

        postulationRepository.deleteById(Long.valueOf(idPostulation));
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "admin/postulation/index");
        return mv;

    }

}
