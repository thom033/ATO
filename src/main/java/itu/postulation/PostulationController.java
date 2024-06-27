package itu.postulation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
import org.springframework.web.servlet.view.RedirectView;

import itu.admin.Admin;
import itu.compatibilite.PosteDetails;
import itu.compatibilite.PosteDetailsRepository;
import itu.compatibilite.PosteDetailsService;
import itu.compatibilite.ResultAcceuilRepository;
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
    public String getMethodName(@PathVariable("idPoste") String idTravail, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        Postulation postulation = new Postulation();

        PosteDetails posteDetails = posteDetailsRepository
                .findById(Long.valueOf(idTravail)).orElseThrow(() -> new RuntimeException("PosteDetails not found"));

        List<Postulation> postulationEffectue = postulationRepository.listePostulation(utilisateur,
                posteDetails);
        if (postulationEffectue.size() > 0) {
            throw new Exception("Vous avez déja postulé pour ce travail");
        }

        postulation.setDate(LocalDateTime.now());
        postulation.setPoste(posteDetails);
        postulation.setUtilisateur(utilisateur);

        if (utilisateur.getPoint() < posteDetails.getPosteCout()) {
            throw new Exception("Vous ne possedez pas assez de point," + utilisateur.getPoint() + " < "
                    + posteDetails.getPosteCout());
        }

        else {
            utilisateur.setPoint(utilisateur.getPoint() - posteDetails.getPosteCout());
            utilisateurRepository.updatePointsPostule(utilisateur.getId(), posteDetails.getPosteCout());

            session.setAttribute("utilisateur", utilisateur);
        }

        postulationRepository.save(postulation);
        return "redirect:/notification/index";
    }

    @GetMapping("/admin/postulation")
    public ModelAndView getMethodName(HttpSession session) {
        ModelAndView mv = new ModelAndView("admin/template");
        Admin admin = (Admin) session.getAttribute("administrateur");
        if (admin == null) {
            mv.setViewName("redirect:/admin/index");
            return mv;
        }

        mv.addObject("page", "postulation/index.jsp");
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

        LocalDateTime dateEntretien = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            dateEntretien = LocalDateTime.parse(date, formatter);
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("admin/template");
            view.addObject("error", "La date de l'embauche n'est pas valide");
            view.addObject("page", "postulation/index.jsp");
            return view;
        }
        Utilisateur utilisateur = utilisateurRepository.getById(Long.valueOf(idUtilisateur));

        Entretien entretien = new Entretien();
        entretien.setDateEntretien(dateEntretien);
        entretien.setDateEnvoi(LocalDateTime.now());

        Postulation postulation = postulationRepository.getById(Long.valueOf(idPostulation));
        entretien.setPoste(postulation.getPoste());
        entretien.setUtilisateur(utilisateur);
        entretien.setReussite(null);
        entretienRepository.save(entretien);

        Notification notification = new Notification();
        notification.setDateNotification(LocalDateTime.now());
        notification.setMessage(
                "Convocation a un entretien d'embauche pour le travail " + entretien.getPoste().getPosteTitre());
        notification.setUtilisateur(utilisateur);

        notification.setEntretien(entretien);
        notificationRepository.save(notification);

        postulationRepository.deleteById(Long.valueOf(idPostulation));
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "postulation/index.jsp");
        return mv;

    }

}
