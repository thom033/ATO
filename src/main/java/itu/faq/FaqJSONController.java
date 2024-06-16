package itu.faq;

import org.springframework.web.bind.annotation.RestController;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FaqJSONController {
    @Autowired
    HistoriqueQuestionRepository historiqueQuestionRepository;

    @GetMapping("/faq/historique")
    public List<HistoriqueQuestion> getMethodName(HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        List<HistoriqueQuestion> historique = historiqueQuestionRepository.findByUtilisateur(utilisateur);
        return historique;
    }

}
